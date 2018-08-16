package server;

import mathinterface.MathInterface;

/**
 *
 * @author Ahmed El-Torky
 */
public class MathServiceImplementation implements MathInterface {

    @Override
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    @Override
    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    @Override
    public double mult(double num1, double num2) {
        return num1 * num2;
    }

    @Override
    public double divid(double num1, double num2) {
        return num1 / num2;
    }
}
