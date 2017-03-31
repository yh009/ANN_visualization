package csci205_proj_hw3;

import csci205_proj_hw3.controller.ANNController;
import csci205_proj_hw3.view.ANNView;
import javafx.application.Application;
import javafx.scene.Scene;
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
 * Date: Mar 30, 2017
 *
 * Time: 8:37:03 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3
 *
 * File: ANNMain
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3;
 *
 * import javafx.application.Application; import javafx.event.ActionEvent;
 * import javafx.event.EventHandler; import javafx.scene.Scene; import
 * javafx.scene.control.Button; import javafx.scene.layout.StackPane; import
 * javafx.stage.Stage; /**
 *
 * @author yh009
 */
public class ANNMain extends Application {

    private ANNView theView;
    private ANNController theCtrl;

    @Override
    public void init() throws Exception {
        super.init();
        this.theView = new ANNView();
        this.theCtrl = new ANNController();
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(this.theView.getRoot());

        primaryStage.setTitle("ANN");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
