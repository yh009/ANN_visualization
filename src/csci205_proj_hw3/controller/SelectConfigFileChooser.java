package csci205_proj_hw3.controller;

import csci205_proj_hw3.view.ANNFileView;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * Date: Mar 31, 2017
 *
 * Time: 1:45:18 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: selectConfigFileChooser
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
public class SelectConfigFileChooser implements EventHandler<ActionEvent> {

    ANNFileView fileView;

    public SelectConfigFileChooser(ANNFileView fileView) {
        this.fileView = fileView;
        this.fileView.getSelectConfig().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        File workingDirectory = new File(System.getProperty("user.dir"));
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Config File");
        fileChooser.setInitialDirectory(workingDirectory);

        File configFile = fileChooser.showOpenDialog(new Stage());
        try {
            fileView.fileSelected(configFile);
        } catch (IOException ex) {
            Logger.getLogger(SelectConfigFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
