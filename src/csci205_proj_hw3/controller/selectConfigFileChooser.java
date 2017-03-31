
import csci205_proj_hw3.view.ANNFileView;
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
 * @author yh009
 */
public class selectConfigFileChooser implements EventHandler<ActionEvent> {

    ANNFileView fileView;

    public selectConfigFileChooser(ANNFileView fileView) {
        this.fileView = fileView;
        this.fileView.getSelectConfig().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Config File");
        fileChooser.showOpenDialog(new Stage());

    }

}
