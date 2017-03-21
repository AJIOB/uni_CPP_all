package AJIOB.model;

/**
 * Created by AJIOB on 21.03.2017.
 *
 * @author AJIOB
 */
public class Vector {
    private double[] coordinates = new double[0];

    /**
     * Returns coordinate on i position
     *
     * @param i Index of coordinate
     * @return Coordinate value
     */
    public double getCoordinate(int i) {
        return coordinates[i];
    }

    /**
     * Set coordinate of i position
     *
     * @param i     Index of coordinate
     * @param value New value of coordinate
     */
    public void setCoordinate(int i, double value) {
        coordinates[i] = value;
    }

    /**
     * Set new size of Vector (quantity of coordinates)
     *
     * @param i New quantity of coordinates
     */
    public void setSize(int i) {
        coordinates = new double[i];
    }

    /**
     * Returns quantity of coordinates
     *
     * @return Current quantity of coordinates
     */
    public int getSize() {
        return coordinates.length;
    }
}
