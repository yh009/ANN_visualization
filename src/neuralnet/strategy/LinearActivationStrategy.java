/* *****************************************
 * CSCI205 - Software Engineering and Design
 * Fall 2016
 *
 * Name: Prof. King
 * Project: NeuralNet
 * Package: neuralnet.strategy
 * File: LinearActivationStrategy
 *
 * ****************************************
 */package neuralnet.strategy;

import java.io.Serializable;

public class LinearActivationStrategy implements ActivationStrategy, Serializable {

    @Override
    public double f(double x) {
        return x;
    }

    @Override
    public double fDeriv(double x) {
        return 1;
    }

}
