package ANN.controller;

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
 * Date: Mar 30, 2017
 *
 * Time: 8:38:06 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3
 *
 * File: FileCtrl
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3;
 *
 * /**
 *
 * @author Yuxuan Huang
 */
import ANN.model.ANNModel;
import ANN.view.ANNFileView;
import ANN.view.ANNView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FileCtrl implements EventHandler<ActionEvent> {

    private ANNModel theModel;
    private ANNView theView;
    private Stage fileStage;
    //private selectConfigFileChooser SCFC;
    private ANNFileView fileView;

    public FileCtrl(ANNModel theModel, ANNView theView) {
        this.theModel = theModel;
        this.theView = theView;

        //this.SCFC = new selectConfigFileChooser(this.fileView);
        this.theView.getFileBtn().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        this.fileStage = new Stage();
        fileStage.setTitle("Choose Option");
        this.fileView = new ANNFileView(theModel, theView);
        //if (theView.g)
        Scene scene = new Scene(fileView.getRoot());
        fileStage.setScene(scene);
        fileStage.sizeToScene();
        fileStage.show();

        // Open a new window with three buttons on it: openANN, saveANN, openData
    }
}
