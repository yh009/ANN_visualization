package csci205_proj_hw3.utility;

import java.io.File;
import java.io.IOException;
import javafx.stage.FileChooser;
import neuralnet.data.LabeledInstances;

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
 * Time: 9:15:25 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.ANNUtility
 *
 * File: ANNFileBtnControllerUtil
 *
 * Description:
 *
 *
 *
 * ****************************************
 * /
 * package csci205_proj_hw3.ANNUtility;
 *
 * /**
 *
 * @author Zilin Ma
 */
public class ANNFileBtnControllerUtil {

    /**
     *
     * @param fileChooser
     * @see TODO
     */
    public static void configureFileChooser(FileChooser fileChooser) {
        fileChooser.setTitle("View Pictures");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.home")));
    }

    private LabeledInstances openDataSetFile(File file) {

        try {
            // Read in a dataset
            LabeledInstances trainData = new LabeledInstances(file.getAbsolutePath(),
                    true, 2);
            return trainData;

        } catch (IOException ex) {
            System.out.println("Cannot open this file.");
        }
        return null;

    }

}
