package AJIOB.model;

/**
 * Created by AJIOB on 21.03.2017.
 *
 * @author AJIOB
 */
public class AddingThread extends Thread {
    private double number1, number2, res;

    public AddingThread(final double number1, final double number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @Override
    public void run() {
        res = number1 + number2;
    }

    public double getRes() {
        return res;
    }
}
