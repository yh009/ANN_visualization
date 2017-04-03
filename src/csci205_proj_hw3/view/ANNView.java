package csci205_proj_hw3.view;

import csci205_proj_hw3.controller.ConfigCtrl;
import csci205_proj_hw3.controller.FileCtrl;
import csci205_proj_hw3.controller.close;
import csci205_proj_hw3.model.ANNModel;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
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
        center = new StackPane();
        center.setAlignment(Pos.CENTER);
        ANNGraph = new HBox(200);
        ANNGraph.setAlignment(Pos.CENTER);

        inputLayer = new VBox(10);
        inputLayer.setAlignment(Pos.CENTER);
        hiddenLayer = new VBox(10);
        hiddenLayer.setAlignment(Pos.CENTER);
        outputLayer = new VBox(10);
        outputLayer.setAlignment(Pos.CENTER);
        ANNGraph.getChildren().addAll(inputLayer, hiddenLayer, outputLayer);
        root.setCenter(center);

        root.setPrefWidth(1500);
        root.setPrefHeight(900);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setTop(topPane);
        lines = new Group();
        center.getChildren().add(lines);
        center.getChildren().add(ANNGraph);

        closeWindow = new close(this);
        theCtrl = new FileCtrl(theModel, this);
        configCtrl = new ConfigCtrl(theModel, this);

    }
    private StackPane center;
    private VBox outputLayer;
    private VBox hiddenLayer;
    private VBox inputLayer;
    private HBox ANNGraph;
    private Line[][] iToh;
    private Line[][] hToo;
    private ArrayList<Double[]> weights;
    private Group lines;

    public void genGraph() {
        ArrayList ANNInfo = theModel.getANNInfo();
        this.inputLayer.getChildren().clear();
        for (int i = 0; i < (Integer) ANNInfo.get(0); i++) {
            this.inputLayer.getChildren().add(new Circle(30, Paint.valueOf("RED")));

        }
        this.hiddenLayer.getChildren().clear();
        for (int j = 0; j < (Integer) ANNInfo.get(1); j++) {
            this.hiddenLayer.getChildren().add(new Circle(30, Paint.valueOf("GREEN")));

        }
        this.outputLayer.getChildren().clear();
        for (int k = 0; k < (Integer) ANNInfo.get(2); k++) {
            this.outputLayer.getChildren().add(new Circle(30, Paint.valueOf("BLUE")));

        }
        this.genLine();

    }

    public void genLine() {
        //weights = theModel.getWeights();

        iToh = new Line[this.inputLayer.getChildren().size()][this.hiddenLayer.getChildren().size()];
        hToo = new Line[this.hiddenLayer.getChildren().size()][this.outputLayer.getChildren().size()];
        //this.root.getChildren().add(iToh);

        for (int i = 0; i < this.inputLayer.getChildren().size(); i++) {
            for (int j = 0; j < this.hiddenLayer.getChildren().size(); j++) {
                iToh[i][j] = new Line();
                iToh[i][j].setStrokeWidth(3);
                this.lines.getChildren().add(iToh[i][j]);
                //iToh[i][j].setVisible(true);

                updateLinePosition(iToh[i][j], (Circle) this.inputLayer.getChildren().get(i), (Circle) this.hiddenLayer.getChildren().get(j));

            }

        }

        for (int k = 0; k < this.hiddenLayer.getChildren().size(); k++) {
            for (int t = 0; t < this.outputLayer.getChildren().size(); t++) {
                hToo[k][t] = new Line();
                hToo[k][t].setStrokeWidth(3);
                //this.ANNGraph.getChildren().add(hToo[k][t]);
                //hToo[k][t].setVisible(true);
                this.lines.getChildren().add(hToo[k][t]);
                updateLinePosition(hToo[k][t], (Circle) this.hiddenLayer.getChildren().get(k), (Circle) this.outputLayer.getChildren().get(t));
            }

        }
    }

    /**
     * Helper function for align the lines
     *
     * @param line - the line object to be aligned
     * @param r1 - from node
     * @param r2 - to node
     */
    private void updateLinePosition(Line line, Circle r1, Circle r2) {
        Point2D p1 = r1.localToScene(r1.getCenterX(), r1.getCenterY());
        //p1 = line.sceneToLocal(p1);
        Point2D p2 = r2.localToScene(r2.getCenterX(), r2.getCenterY());
        //p2 = line.sceneToLocal(p2);
        line.setStartX(p1.getX());
        line.setStartY(p1.getY());
        line.setEndX(p2.getX());
        line.setEndY(p2.getY());
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

    public HBox getANNGraph() {
        return ANNGraph;
    }

}
