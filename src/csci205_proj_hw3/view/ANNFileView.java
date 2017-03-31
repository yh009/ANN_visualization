package csci205_proj_hw3.view;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

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
    private HBox root;

    public ANNFileView() {
        selectConfig = new Button("Select Config");
        saveConfig = new Button("Save Config");
        selectData = new Button("Select Test File");
        exit = new Button("Exit");

        root = new HBox(10);
        root.setPrefHeight(100);
        root.setPrefWidth(500);
        root.getChildren().addAll(selectConfig, saveConfig, selectData, exit);

    }

    public HBox getRoot() {
        return root;
    }

}
