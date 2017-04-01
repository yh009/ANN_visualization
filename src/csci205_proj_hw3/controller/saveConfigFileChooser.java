package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNFileView;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
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
 * Time: 12:17:54 AM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: saveConfigFileChooser
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
public class saveConfigFileChooser implements EventHandler<ActionEvent> {

    ANNFileView fileView;
    ANNModel theModel;

    public saveConfigFileChooser(ANNFileView fileView, ANNModel theModel) {
        this.fileView = fileView;
        this.theModel = theModel;
        fileView.getSaveConfig().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Config File");
        fileChooser.setInitialDirectory(workingDirectory);

        File dest = fileChooser.showSaveDialog(new Stage());

        if (dest != null) {
            theModel.saveANN(dest.getAbsolutePath());

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Incorrect input!");
            alert.setHeaderText("Incorrect input specified!");
            alert.setContentText("Please enter a filename!");

            alert.show();
        }
    }

}
