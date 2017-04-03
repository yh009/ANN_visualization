package csci205_proj_hw3.view;

import csci205_proj_hw3.controller.ConfigCtrl;
import csci205_proj_hw3.controller.FileCtrl;
import csci205_proj_hw3.controller.close;
import csci205_proj_hw3.model.ANNModel;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
    private VBox outputLayer;
    private VBox hiddenLayer;
    private VBox inputLayer;
    private Group ANNGraph;
    private Line[][] iToh;
    private Line[][] hToo;

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
        /*
         * ANNGraph = new HBox(200); ANNGraph.setAlignment(Pos.CENTER);
         * inputLayer = new VBox(10); inputLayer.setAlignment(Pos.CENTER);
         * hiddenLayer = new VBox(10); hiddenLayer.setAlignment(Pos.CENTER);
         * outputLayer = new VBox(10); outputLayer.setAlignment(Pos.CENTER);
         *
         * ANNGraph.getChildren().addAll(inputLayer, hiddenLayer, outputLayer);
         */
        ANNGraph = new Group();

        root.setCenter(ANNGraph);

        root.setPrefWidth(1500);
        root.setPrefHeight(900);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setTop(topPane);
        closeWindow = new close(this);
        theCtrl = new FileCtrl(theModel, this);
        configCtrl = new ConfigCtrl(theModel, this);

    }

    public void genGraph() {

        ArrayList ANNInfo = theModel.getANNInfo();
        /*
         * this.inputLayer.getChildren().clear(); for (int i = 0; i < (Integer)
         * ANNInfo.get(0); i++) { this.inputLayer.getChildren().add(new
         * Circle(50, Paint.valueOf("RED")));
         *
         * }
         * this.hiddenLayer.getChildren().clear(); for (int j = 0; j < (Integer)
         * ANNInfo.get(1); j++) { this.hiddenLayer.getChildren().add(new
         * Circle(50, Paint.valueOf("GREEN")));
         *
         * }
         * this.outputLayer.getChildren().clear(); for (int k = 0; k < (Integer)
         * ANNInfo.get(2); k++) { this.outputLayer.getChildren().add(new
         * Circle(50, Paint.valueOf("BLUE")));
         *
         * }
         */
        ANNGraph.getChildren().clear();
        ArrayList<Circle> circles = new ArrayList<>();
        // add output layer
        for (int i = 0; i < (int) ANNInfo.get(2); i++) {
            Circle c = new Circle(50, Paint.valueOf("BLUE"));
            circles.add(c);
            c.setCenterX(1250);
            c.setCenterY(900 / (((int) ANNInfo.get(2))) * (i + 1));
        }

        // add hidden layer
        for (int i = 0; i < (int) ANNInfo.get(1); i++) {
            Circle c = new Circle(50, Paint.valueOf("GREEN"));
            circles.add(c);
            c.setCenterX(750);
            c.setCenterY(900 / (((int) ANNInfo.get(1))) * (i + 1));
        }

        // add input layer
        for (int i = 0; i < (int) ANNInfo.get(0); i++) {
            Circle c = new Circle(50, Paint.valueOf("RED"));
            circles.add(c);
            c.setCenterX(250);
            c.setCenterY(900 / (((int) ANNInfo.get(0))) * (i + 1));
        }

        //this.genLine();
        // draw lines
        int numInputs = theModel.getANNInfo().get(0);

        int numHidden = theModel.getANNInfo().get(1);

        int numOutputs = theModel.getANNInfo().get(2);

        ArrayList<Line> lineArray = new ArrayList<>();
        for (int i = 0; i < numOutputs; i++) {
            for (int j = 0; j < numHidden; j++) {
                // add a line segment
                //lineArray.add(drawLineFromTo((Circle) circles.get(i), (Circle) circles.get(numOutputs + j)));
                ANNGraph.getChildren().add(drawLineFromTo(circles.get(i), circles.get(numOutputs + j)));
            }
        }

        for (int i = 0; i < numHidden; i++) {
            for (int j = 0; j < numInputs; j++) {
                // add a line segment
                //lineArray.add(drawLineFromTo((Circle) circles.get(numOutputs + i), (Circle) circles.get(numOutputs + +numOutputs + j)));
                ANNGraph.getChildren().add(drawLineFromTo(circles.get(i), circles.get(numOutputs + j)));
            }
        }
        // add the lines
        //for (Line l : lineArray) {
        //    ANNGraph.getChildren().add(l);
        //}

        for (Circle c : circles) {
            ANNGraph.getChildren().add(c);
        }
    }

    public void genLine() {

    }

    public Line drawLineFromTo(Circle a, Circle b) {
        return new Line(a.getCenterX(), a.getCenterY(), b.getCenterY(), b.getCenterY());

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

    public VBox getOutputLayer() {
        return outputLayer;
    }

    public VBox getHiddenLayer() {
        return hiddenLayer;
    }

    public VBox getInputLayer() {
        return inputLayer;
    }

    public Group getANNGraph() {
        return ANNGraph;
    }

}
