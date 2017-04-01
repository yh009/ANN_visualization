package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNConfigView;
import csci205_proj_hw3.view.ANNView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
 * Date: Apr 1, 2017
 *
 * Time: 12:31:12 AM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.controller
 *
 * File: ConfigCtrl
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3.controller;
 *
 * /**
 *
 * @author mac
 */
public class ConfigCtrl implements EventHandler<ActionEvent> {

    private ANNModel theModel;
    private ANNView theView;
    private Stage fileStage;
    private ANNConfigView configView;

    public ConfigCtrl(ANNModel theModel, ANNView theView) {
        this.theModel = theModel;
        this.theView = theView;
        theView.getConfigBtn().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        this.fileStage = new Stage();
        fileStage.setTitle("Enter Config");
        this.configView = new ANNConfigView(theModel, theView);
        //if (theView.g)
        Scene scene = new Scene(configView.getRoot());
        fileStage.setScene(scene);
        fileStage.sizeToScene();
        fileStage.show();
    }

}
