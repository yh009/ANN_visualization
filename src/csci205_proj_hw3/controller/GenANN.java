package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNConfigView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

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
    private ANNConfigView configView;

    public GenANN(ANNModel theModel, ANNConfigView configView) {
        this.theModel = theModel;
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

}