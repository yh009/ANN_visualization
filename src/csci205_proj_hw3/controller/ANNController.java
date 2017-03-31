package csci205_proj_hw3.controller;

import csci205_proj_hw3.model.ANNModel;
import csci205_proj_hw3.view.ANNView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class ANNController implements EventHandler<ActionEvent> {

    private ANNModel theModel;
    private ANNView theView;

    public ANNController(ANNModel theModel, ANNView theView) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.getFileBtnConvert().setOnAction(this);

    }

    @Override
    public void handle(ActionEvent event) {
        // Open a new window with three buttons on it: openANN, saveANN, openData
        try {
            Scene nextWindow = new Scene(this.);

        } catch (IOException e) {
            e.printStackTrace();
        }

        /*
         * try { // file chooser. final FileChooser fileChooser = new
         * FileChooser(); configureFileChooser(fileChooser); File file =
         * fileChooser.showOpenDialog(stage);// TODO block the window input if
         * (file != null) { LabeledInstances labeledInstances = new
         * LabeledInstances(file.getAbsolutePath(), true, 2);
         *
         *
         * }
         * } catch (FileNotFoundException ex) {
         * Logger.getLogger(ANNFileBtnController.class.getName()).log(Level.SEVERE,
         * null, ex); }
         */
    }
}
