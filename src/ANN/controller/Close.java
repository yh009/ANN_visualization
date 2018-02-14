package ANN.controller;

import ANN.view.ANNFileView;
import ANN.view.ANNView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * Date: Mar 31, 2017
 *
 * Time: 11:14:06 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: close
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
 * @author Yuxuan Huang
 */
public class Close implements EventHandler<ActionEvent> {

    private ANNFileView fileView;
    private ANNView theView;

    public Close(ANNFileView fileView) {
        this.fileView = fileView;
        fileView.getExit().setOnAction(this);

    }

    public Close(ANNView theView) {
        this.theView = theView;
        theView.getExitBtn().setOnAction(this);
    }

    @Override
    public void handle(ActionEvent event) {
        if (fileView != null) {
            Stage stage = (Stage) fileView.getExit().getScene().getWindow();
            //fileView.getRoot().getScene().setRoot(null);

            stage.hide();

        }
        if (theView != null) {
            //Stage stage = (Stage) theView.getExitBtn().getScene().getWindow();
            //stage.hide();
            Platform.exit();
        }

    }

}
