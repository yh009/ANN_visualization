/* *****************************************
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
 * Time: 6:06:27 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3.model
 *
 * File: ANNModelTest
 *
 * Description:
 *
 *
 *
 **************************************** */
package csci205_proj_hw3.model;

import ANN.model.ANNModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import neuralnet.ANN;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Yuxuan Huang
 */
public class ANNModelTest {

    public ANNModelTest() {
    }
    ANN myANN;
    ANNModel am;

    @Before
    public void setUp() {
        myANN = new ANN(2, 5, 1);
        am = new ANNModel(myANN, null);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of readANNConfig method, of class ANNModel.
     */
    @Test
    public void testReadANNConfig() {
        System.out.println("readANNConfig");
        int inputNodes = 0;
        int hiddenNodes = 0;
        int outputNodes = 0;
        ANNModel instance = new ANNModel();
        instance.readANNConfig(inputNodes, hiddenNodes, outputNodes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of readAnn method, of class ANNModel.
     */
    @Test
    public void testReadAnn() throws Exception {
        System.out.println("readAnn");
        File file = null;
        ANNModel instance = new ANNModel();
        instance.readAnn(file);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveANN method, of class ANNModel.
     */
    @Test
    public void testSaveANN() throws Exception {
        System.out.println("saveANN");
        String dir = "";
        ANNModel instance = new ANNModel();
        instance.saveANN(dir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openTrainData method, of class ANNModel.
     */
    @Test
    public void testOpenTrainData() throws Exception {
        System.out.println("openTrainData");
        String dir = "";
        ANNModel instance = new ANNModel();
        instance.openTrainData(dir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trainOneInstance method, of class ANNModel.
     */
    @Test
    public void testTrainOneInstance() {
        System.out.println("trainOneInstance");
        ANNModel instance = new ANNModel();
        instance.trainOneInstance();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runMultipleEpoch method, of class ANNModel.
     */
    @Test
    public void testRunMultipleEpoch() {
        System.out.println("runMultipleEpoch");
        int numEpoch = 0;
        ANNModel instance = new ANNModel();
        instance.runMultipleEpoch(numEpoch);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of classifyData method, of class ANNModel.
     */
    @Test
    public void testClassifyData() {
        System.out.println("classifyData");
        ANNModel instance = new ANNModel();
        instance.classifyData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getANNInfo method, of class ANNModel.
     */
    @Test
    public void testGetANNInfo() {
        System.out.println("getANNInfo");
        ANNModel instance = new ANNModel();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getANNInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeights method, of class ANNModel.
     */
    @Test
    public void testGetWeights() {
        ArrayList<Double[]> weightss = am.getWeights();
        for (Double[] weight : weightss) {
            System.out.println(Arrays.toString(weight));
        }
    }

    /**
     * Test of changeActivationFunction method, of class ANNModel.
     */
    @Test
    public void testChangeActivationFunction() {
        System.out.println("changeActivationFunction");
        String actString = "";
        ANNModel instance = new ANNModel();
        instance.changeActivationFunction(actString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeLearningRate method, of class ANNModel.
     */
    @Test
    public void testChangeLearningRate() {
        System.out.println("changeLearningRate");
        double learningRate = 0.0;
        ANNModel instance = new ANNModel();
        instance.changeLearningRate(learningRate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeMomentum method, of class ANNModel.
     */
    @Test
    public void testChangeMomentum() {
        System.out.println("changeMomentum");
        double momentum = 0.0;
        ANNModel instance = new ANNModel();
        instance.changeMomentum(momentum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
