package model;

/**
 * Created by Alex on 21.02.2017.
 */
public class Body {
    private double length;
    private double width;
    private double height;

    private double mass;

    public Body(final double length, final double width, final double height, final double mass) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.mass = mass;
    }

    /**
     * Return length
     *
     * @return length
     */
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getMass() {
        return mass;
    }

    public double geDensity() {
        return (length * width * height / mass);
    }
}
