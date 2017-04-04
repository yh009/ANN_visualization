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
 * Time: 8:26:40 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: ClassifyOneLineCtrl
 *
 * Description:
 *
 *
 *
 **************************************** */
package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 *
 * @author Zilin Ma
 */
public class ClassifyOneLineCtrl implements EventHandler<ActionEvent> {

    private ANNView theView;
    private ANNModel theModel;

    public ClassifyOneLineCtrl(ANNView theView, ANNModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        this.theView.getClassifyOneLineBtn().setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (theModel.getData() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("CSV unspecified.");
            alert.setHeaderText("CSV unspecified.");
            alert.setContentText("please select your train/classify file.");
            alert.show();
        } else {
            theModel.classifyInstance();
            System.out.println(theModel.getInstance().toString());
            System.out.println(theModel.getInstanceOutput().toString());
        }
        // update inputs and outputs.
    }

}
