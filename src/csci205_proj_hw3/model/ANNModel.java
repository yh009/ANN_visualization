package csci205_proj_hw3.model;

import csci205_proj_hw3.utility.ANNUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import neuralnet.ANN;
import neuralnet.Edges;
import neuralnet.data.LabeledInstances;
import neuralnet.data.UnlabeledInstance;
import neuralnet.strategy.ActivationStrategy;
import neuralnet.strategy.LinearActivationStrategy;
import neuralnet.strategy.LogisticActivationStrategy;
import neuralnet.strategy.ReLUActivationStrategy;
import neuralnet.strategy.SoftplusActivationStrategy;

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
 * Time: 8:38:20 PM
 *
 *
 *
 * Project: csci205_proj_hw3
 *
 * Package: csci205_proj_hw3
 *
 * File: ANNModel
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
public class ANNModel {

    private ANN myANN;
    private LabeledInstances data = null;
    private int indexPointer = 0;
    private UnlabeledInstance instance;
    private ArrayList<Double> instanceOutput;

    public ANNModel() {

    }

    public ANNModel(ANN myANN, LabeledInstances data) {
        this.myANN = myANN;
        this.data = data;
    }

    /**
     * Read in for the new ANNConfig.
     *
     * @param inputNodes Number of input nodes.
     * @param hiddenNodes Number of hidden nodes.
     * @param outputNodes Number of output nodes.
     */
    public void readANNConfig(int inputNodes, int hiddenNodes, int outputNodes) {
        myANN = new ANN(inputNodes, hiddenNodes, outputNodes);
    }

    /**
     * Read in a serilized ANN file.
     *
     * @param file
     * @throws java.io.IOException
     */
    public void readAnn(File file) {
        try {
            myANN = ANNUtil.deserializeANN(file.getAbsolutePath());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ANNModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("Cannot parse serilization.");
        }
    }

    /**
     * Save file in a given dir
     *
     * @param dir the name of the directory where the current ANN is stored.
     * @throws java.io.IOException
     */
    public void saveANN(String dir) throws IOException {
        ANNUtil.serializeANN(myANN, dir);

    }

    /**
     * Opens the trian data and put it into the ANN.
     *
     * @param dir The absolute directory of the file
     * @throws FileNotFoundException
     */
    public void openTrainData(String dir) {
        try {
            data = new LabeledInstances(dir,
                    true, 2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ANNModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Trains one instance and increment index pointer. Only classify one
     * instance and the index of this instance is the current value of
     * indexPointer. TODO
     */
    public void trainOneInstance() {
        myANN.classifyInstance(data.get(indexPointer));

        indexPointer++;
    }

    /**
     * Classify next line of instance.
     */
    public void classifyInstance() {
        this.instanceOutput = myANN.classifyInstance(data.get(indexPointer));
        instance = data.get(indexPointer);
        indexPointer++;

    }

    /**
     * Runs numEpoch number of epochs, and train the ANN.
     */
    public void runMultipleEpoch(int numEpoch) {
        for (int i = 0; i < numEpoch; i++) {
            myANN.learn(data, true, 1);

        }
    }

    /**
     * Classify a group of data. TODO
     */
    public void classifyData() {
        myANN.classifyInstances(data);
    }

    /**
     * Return the dimension of the layer as a list of integers. The first
     * integer is the number of neurons of input layers and so on. The format
     * is: [input][hidden][output]
     *
     * @return Dimension of the array.
     */
    public ArrayList<Integer> getANNInfo() {
        return myANN.getANNLayerDim();
    }

    /**
     * Returns the weights as an array list of ARRAY of weights. The first index
     * represent the first node in the output layer, and this moves down.
     *
     * @return array list of ARRAYs.
     */
    public ArrayList<Double[]> getWeights() {
        ArrayList<Integer> dim = myANN.getANNLayerDim();
        int numInput = dim.get(0);
        int numHidden = dim.get(1);
        int numOutput = dim.get(2);
        ArrayList<Double[]> edges = new ArrayList<>();
        Edges e = myANN.getEdges(1);
        for (int i = 0; i < numOutput; i++) {
            Double[] weights = new Double[numHidden];
            for (int j = 0; j < numHidden; j++) {
                Double weight = e.getEdge(i, j).getWeight();
                weights[j] = weight;
            }
            edges.add(weights);
        }
        e = myANN.getEdges(0);
        for (int i = 0; i < numHidden; i++) {
            Double[] weights = new Double[numInput];
            for (int j = 0; j < numInput; j++) {
                Double weight = e.getEdge(i, j).getWeight();
                weights[j] = weight;
            }
            edges.add(weights);
        }

        return edges;
    }

    /**
     * change the activation function as specified using a string with the exact
     * name of the activation function.
     *
     * @param actString the name of the activation function.
     */
    public void changeActivationFunction(String actString) {
        ActivationStrategy as = null;
        switch (actString) {
            case "Linear":
                as = new LinearActivationStrategy();
                break;
            case "Logistic":
                as = new LogisticActivationStrategy();
                break;
            case "ReLU":
                as = new ReLUActivationStrategy();
                break;
            case "Softplus":
                as = new SoftplusActivationStrategy();
                break;
        }
        if (as == null) {
            as = new LinearActivationStrategy();
        }
        ANN.setActivation(as);
    }

    /**
     * Changes the learning rate of the current ANN.
     *
     * @param learningRate
     */
    public void changeLearningRate(double learningRate) {
        ANN.learningRate = learningRate;
    }

    /**
     * Changes the momentum of the current ANN.
     *
     * @param momentum
     */
    public void changeMomentum(double momentum) {
        ANN.momentum = momentum;
    }

    public LabeledInstances getData() {
        return data;
    }

    public ANN getMyANN() {
        return myANN;
    }

    public UnlabeledInstance getInstance() {
        return instance;
    }

}
