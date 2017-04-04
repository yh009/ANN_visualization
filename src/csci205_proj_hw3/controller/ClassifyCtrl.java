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
 * Time: 5:21:31 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: ClassifyCtrl
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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import neuralnet.ANN;

/**
 *
 * @author Zilin Ma
 */
public class ClassifyCtrl implements EventHandler<ActionEvent> {

    private ANNView theView;
    private ANNModel theModel;

    public ClassifyCtrl(ANNView theView, ANNModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.getBtnClassify().setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        int epoch;
        if (theModel.getData() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CSV unspecified.");
            alert.setHeaderText("CSV unspecified.");
            alert.setContentText("please select your train/classify file.");
            alert.show();
        } else {
            try {
                ArrayList<ArrayList<Double>> output = new ArrayList<>();
                output = theModel.getMyANN().classifyInstances(theModel.getData());
                double totalError = ANN.computeOutputError(theModel.getData(), output);
                theView.getError().textProperty().set(String.format("Error: %4.3f", totalError));

            } catch (NumberFormatException numberFormatException) {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Incorrect input!");
                alert.setHeaderText("Incorrect input specified!");
                alert.setContentText("Please type integer in # epoch and doubles in Learning rate and Momentum!");

                alert.show();

            }
            /*
             * Thread th = new Thread(theTask); th.setDaemon(true); th.start();
             *
             */

        }

    }

}
