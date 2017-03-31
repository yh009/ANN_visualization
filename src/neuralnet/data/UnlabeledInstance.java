/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * Name: Prof. King
 * Project: NeuralNet
 * Package: neuralnet.data
 * File: UnlabeledInstance
 * Description:
 *
 * ****************************************
 */
package neuralnet.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author brk009
 */
public class UnlabeledInstance extends ArrayList<Double> implements Serializable {

    public UnlabeledInstance() {
        super();
    }

    /**
     * Initialize an Instance with a array of values
     *
     * @param xVec
     */
    public UnlabeledInstance(double[] xVec) {
        super(xVec.length);
        for (double x : xVec) {
            this.add(x);
        }
    }

}
