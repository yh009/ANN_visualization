package csci205_proj_hw3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public ANNView() {
        fileBtn = new Button("File");
        fileBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("File press");
            }
        });

        configBtn = new Button("Config");
        configBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Config press");
            }
        });

        exitBtn = new Button("Exit");
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Exit press");
            }
        });

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
        /*
         * combo.setVisible(false); txtCombo.setOnMouseEntered(event ->
         * combo.setVisible(true));
         * combo.showingProperty().addListener(ovservable -> { if
         * (!combo.isShowing()) { combo.setVisible(false); }
         *
         * }); combo.setOnMouseExited(event -> { if (!combo.isShowing()) {
         * combo.setVisible(false); } });
         */

        root = new BorderPane();
        topPane = new HBox(10);
        topPane.getChildren().addAll(fileBtn, configBtn, txtLR, inputLR, txtMo, inputMo, txtCombo, combo, exitBtn);
        topPane.setAlignment(Pos.CENTER);
        root.setPrefWidth(1500);
        root.setPrefHeight(900);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setTop(topPane);

    }

    public BorderPane getRoot() {
        return root;
    }

}
