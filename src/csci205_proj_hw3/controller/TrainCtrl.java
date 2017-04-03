/* *****************************************
 *
 * CSCI205 - Software Engineering and Design
 *
 * Spring 2017
 *
 *
 *
 * Name: Zilin Ma, Yuxuan Huang
 *
 * Date: Apr 3, 2017
 *
 * Time: 12:41:37 AM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: TrainCtrl
 *
 * Description:
 *
 *
 *
 **************************************** */
package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNView;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import neuralnet.ANN;
import neuralnet.data.LabeledInstances;

/**
 *
 * @author Zilin Ma
 */
public class TrainCtrl implements EventHandler<ActionEvent> {

    private ANNModel theModel;
    private ANNView theView;
    private RunEpochTask theTask;

    public TrainCtrl(ANNModel theModel, ANNView theView) {
        this.theModel = theModel;
        this.theView = theView;
        theView.getTrainButton().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        int epoch;
        if (theView.getTrainField().getText() != "") {
            try {
                epoch = Integer.parseInt(theView.getTrainField().getText());
                if (theView.getTxtLR().getText() != "") {
                    theModel.changeLearningRate(Integer.parseInt(theView.getTxtLR().getText()));
                }
                if (theView.getTxtMo().getText() != "") {
                    theModel.changeMomentum(Integer.parseInt(theView.getTxtMo().getText()));
                }
                theModel.changeActivationFunction(theView.getTxtCombo().getText());

                theTask = new RunEpochTask(theModel.getMyANN(), epoch, theModel.getData());
                theView.getNumEpoch().textProperty().bind(theTask.valueProperty().asString());
                theView.getError().textProperty().bind(theTask.messageProperty());
            } catch (NumberFormatException numberFormatException) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect input!");
                alert.setHeaderText("Incorrect input specified!");
                alert.setContentText("Please type integer in the # of epoch!");

                alert.show();

            }
            /*
             * if (theView.getTxtLR().getText() != "") { try {
             * theModel.changeLearningRate(Integer.parseInt(theView.getTxtLR().getText()));
             * } catch (NumberFormatException numberFormatException) { Alert
             * alert = new Alert(Alert.AlertType.ERROR);
             * alert.setTitle("Incorrect input!");
             * alert.setHeaderText("Incorrect input specified!");
             * alert.setContentText("Please type integer in the Learning rate
             * field!");
             *
             * alert.show();
             *
             * }
             * }
             * if (theView.getTxtMo().getText() != "") { try {
             * theModel.changeMomentum(Integer.parseInt(theView.getTxtMo().getText()));
             * } catch (NumberFormatException numberFormatException) { Alert
             * alert = new Alert(Alert.AlertType.ERROR);
             * alert.setTitle("Incorrect input!");
             * alert.setHeaderText("Incorrect input specified!");
             * alert.setContentText("Please type integer in the Momentum
             * field!");
             *
             * alert.show();
             *
             * }
             * }
             *
             */

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
