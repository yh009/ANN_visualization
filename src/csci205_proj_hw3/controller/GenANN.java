package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNConfigView;
import csci205_proj_hw3.view.ANNView;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import neuralnet.ANN;
import neuralnet.data.LabeledInstances;

/*
 * *****************************************
 *
 * CSCI205 - Software Engineering and Design
 *
 * Spring 2017
 *
 *
 *
 * Name: Zilin Ma, Yuxuan Huang
 *
 * Date: Apr 1, 2017
 *
 * Time: 3:25:10 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: GenANN
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3.controller;
 *
 * /**
 *
 * @author mac
 */
public class GenANN implements EventHandler<ActionEvent> {

    private ANNModel theModel;
    private ANNView theView;
    private ANNConfigView configView;
    private RunEpochTask theTask;

    public GenANN(ANNModel theModel, ANNConfigView configView, ANNView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.configView = configView;
        configView.getGenANN().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        try {
            int numInput = Integer.parseInt(configView.getNumInput().getText());
            int numHidden = Integer.parseInt(configView.getNumHidden().getText());
            int numOutput = Integer.parseInt(configView.getNumOutput().getText());
            theModel.readANNConfig(numInput, numHidden, numOutput);
            theView.genGraph();

            //TODO generate graph
            Stage stage = (Stage) configView.getGenANN().getScene().getWindow();
            stage.hide();
        } catch (NumberFormatException numberFormatException) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.setContentText("Please type integer in the fields!");

            alert.show();
        }
    }

    class RunEpochTask extends Task<Double> {

        private final int epoch;
        private final ANN ann;
        private final LabeledInstances trainData;

        /**
         *
         * @param ann ANN model that produces the computation.
         * @param numIterations Number of iterations needed
         */
        public RunEpochTask(ANN ann, int numIterations, LabeledInstances trainData) {
            this.ann = ann;
            this.epoch = numIterations;
            this.trainData = trainData;
        }

        @Override
        protected Double call() throws Exception {
            double totalError = 0;
            for (int i = 0; i < epoch; i++) {
                ann.learn(trainData, true, 1);
                ArrayList<ArrayList<Double>> output = ann.classifyInstances(trainData);
                if (isCancelled()) {
                    updateMessage("Cancelled");
                    break;

                }
                totalError = ANN.computeOutputError(trainData, output);
                updateValue(totalError);
                updateMessage(String.format("%d epochs", i));
                updateProgress(i, epoch);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        // update GUI. TODO
                        System.out.println("test");
                    }

                });

                Thread.sleep(1);
            }
            return totalError;
        }

    }

}
