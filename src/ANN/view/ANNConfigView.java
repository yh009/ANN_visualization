package ANN.view;

import ANN.controller.GenANN;
import ANN.model.ANNModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
 * Date: Apr 1, 2017
 *
 * Time: 12:33:47 AM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.view
 *
 * File: ANNConfigView
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
 * @author Yuxuan Huang
 */
public class ANNConfigView {

    private TextField numOutput;
    private TextField numHidden;
    private TextField numInput;
    private VBox root;
    private Button genANN;
    private GenANN createANN;
    private ANNModel theModel;
    private ANNView theView;

    public ANNConfigView(ANNModel theModel, ANNView theView) {
        genANN = new Button("Generate ANN");
        this.theModel = theModel;
        this.theView = theView;

        root = new VBox(10);
        root.setPadding(new Insets(10, 15, 15, 15));
        root.setAlignment(Pos.CENTER);

        HBox one = new HBox(10);
        one.setAlignment(Pos.CENTER);
        numInput = new TextField();
        numInput.setAlignment(Pos.CENTER);
        numInput.setPrefColumnCount(5);
        one.getChildren().addAll(new Label("# input nodes: "), numInput);

        HBox two = new HBox(10);
        two.setAlignment(Pos.CENTER);
        numHidden = new TextField();
        numHidden.setAlignment(Pos.CENTER);
        numHidden.setPrefColumnCount(5);
        two.getChildren().addAll(new Label("# hidden nodes: "), numHidden);

        HBox three = new HBox(10);
        three.setAlignment(Pos.CENTER);
        numOutput = new TextField();
        numOutput.setAlignment(Pos.CENTER);
        numOutput.setPrefColumnCount(5);
        three.getChildren().addAll(new Label("# output node: "), numOutput);

        root.getChildren().addAll(one, two, three, genANN);
        //theModel = theModel;
        createANN = new GenANN(theModel, this, theView);

    }

    public TextField getNumOutput() {
        return numOutput;
    }

    public TextField getNumHidden() {
        return numHidden;
    }

    public TextField getNumInput() {
        return numInput;
    }

    public VBox getRoot() {
        return root;
    }

    public Button getGenANN() {
        return genANN;
    }

}
