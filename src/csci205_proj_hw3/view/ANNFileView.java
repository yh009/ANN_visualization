package csci205_proj_hw3.view;

import csci205_proj_hw3.controller.close;
import csci205_proj_hw3.controller.saveConfigFileChooser;
import csci205_proj_hw3.controller.selectConfigFileChooser;
import csci205_proj_hw3.controller.selectTestFileChooser;
import csci205_proj_hw3.model.ANNModel;
import java.io.File;
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
    private selectConfigFileChooser selectConfigFC;
    private saveConfigFileChooser saveConfigFC;
    private selectTestFileChooser testFC;
    //private File selectedFile;
    private File selectedData;
    private close closeWindow;
    private ANNModel theModel;

    public ANNFileView(ANNModel theModel) {
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
        selectConfigFC = new selectConfigFileChooser(this);
        saveConfigFC = new saveConfigFileChooser(this);
        testFC = new selectTestFileChooser(this);
        closeWindow = new close(this);
        this.theModel = theModel;
        //root.setAlignment(Pos.CENTER);

    }

    public void fileSelected(File selectedFile) {
        //this.selectedFile = selectedFile;
        theModel.readSerilizationAnn(selectedFile);
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
