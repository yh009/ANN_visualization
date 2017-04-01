package csci205_proj_hw3.view;

import csci205_proj_hw3.controller.ConfigCtrl;
import csci205_proj_hw3.controller.FileCtrl;
import csci205_proj_hw3.controller.close;
import csci205_proj_hw3.model.ANNModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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
 * Time: 8:37:54 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3
 *
 * File: ANNView
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
 * @author yh009
 */
public class ANNView {

    private ANNModel theModel;
    private BorderPane root;
    private Button exitBtn;
    private Button configBtn;
    private Button fileBtn;
    private HBox topPane;
    private TextField inputMo;
    private Label txtMo;
    private TextField inputLR;
    private Label txtLR;
    private Label txtCombo;
    private ComboBox<String> combo;
    private close closeWindow;
    private FileCtrl theCtrl;
    private ConfigCtrl configCtrl;

    public ANNView(ANNModel theModel) {
        this.theModel = theModel;

        fileBtn = new Button("File");

        configBtn = new Button("Config");

        exitBtn = new Button("Exit");

        txtLR = new Label("Learning Rate:");
        inputLR = new TextField();
        inputLR.setPrefColumnCount(5);
        txtMo = new Label("Momentum:");
        inputMo = new TextField();
        inputMo.setPrefColumnCount(5);
        txtCombo = new Label("Activation Strategy:");
        //txtCombo.textProperty().bind(combo.getSelectionModel().selectedItemProperty());
        combo = new ComboBox<>();
        combo.getItems().setAll("Linear", "Logistic", "ReLU", "Softplus");
        combo.getSelectionModel().select(0);

        root = new BorderPane();
        topPane = new HBox(10);
        topPane.getChildren().addAll(fileBtn, configBtn, txtLR, inputLR, txtMo, inputMo, txtCombo, combo, exitBtn);
        topPane.setAlignment(Pos.CENTER);
        root.setPrefWidth(1500);
        root.setPrefHeight(900);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setTop(topPane);
        closeWindow = new close(this);
        theCtrl = new FileCtrl(theModel, this);
        configCtrl = new ConfigCtrl(theModel, this);

    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getExitBtn() {
        return exitBtn;
    }

    public Button getConfigBtn() {
        return configBtn;
    }

    public Button getFileBtn() {
        return fileBtn;
    }

    public ComboBox<String> getCombo() {
        return combo;
    }

}
