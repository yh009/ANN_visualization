package csci205_proj_hw3.view;

import csci205_proj_hw3.controller.Close;
import csci205_proj_hw3.controller.SaveConfigFileChooser;
import csci205_proj_hw3.controller.SelectConfigFileChooser;
import csci205_proj_hw3.controller.SelectTestFileChooser;
import csci205_proj_hw3.model.ANNModel;
import java.io.File;
import java.io.IOException;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

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
 * Time: 9:46:07 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.view
 *
 * File: ANNFileView
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3.view;
 *
 * /**
 *
 * @author Zilin Ma
 */
public class ANNFileView {

    private Button selectConfig;
    private Button saveConfig;
    private Button selectData;
    private Button exit;
    private FlowPane root;
    private SelectConfigFileChooser selectConfigFC;
    private SaveConfigFileChooser saveConfigFC;
    private SelectTestFileChooser testFC;
    //private File selectedFile;
    private File selectedData;
    private Close closeWindow;
    private ANNModel theModel;
    private ANNView theView;

    public ANNFileView(ANNModel theModel, ANNView theView) {
        selectConfig = new Button("Select Config");
        saveConfig = new Button("Save Config");
        selectData = new Button("Select Test File");
        exit = new Button("Exit");
        //FlowPane centerPane = new FlowPane(Orientation.HORIZONTAL);
        //centerPane.setAlignment(Pos.CENTER);
        //centerPane.setHgap(10);

        root = new FlowPane(Orientation.HORIZONTAL);
        //root.setPrefHeight(100);
        //root.setPrefWidth(500);
        root.getChildren().addAll(selectConfig, saveConfig, selectData, exit);
        root.setHgap(30);
        selectConfigFC = new SelectConfigFileChooser(this);
        saveConfigFC = new SaveConfigFileChooser(this, theModel);
        testFC = new SelectTestFileChooser(this, theModel);
        closeWindow = new Close(this);
        this.theModel = theModel;
        this.theView = theView;
        //root.setAlignment(Pos.CENTER);

    }

    public void fileSelected(File selectedFile) throws IOException {
        //this.selectedFile = selectedFile;
        theModel.readAnn(selectedFile);
        theView.genGraph();

        //TODO action for selected file
    }

    public void dataSelected(File selectedData) {
        this.selectedData = selectedData;
        //TODO
    }

    public FlowPane getRoot() {
        return root;
    }

    public Button getSelectConfig() {
        return selectConfig;
    }

    public Button getSaveConfig() {
        return saveConfig;
    }

    public Button getSelectData() {
        return selectData;
    }

    public Button getExit() {
        return exit;
    }

}
