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

public class LinearActivationStrategy implements ActivationStrategy {
    @Override
    public double f(double x) {
        return x;
    }

    @Override
    public double fDeriv(double x) {
        return 1;
    }

}
