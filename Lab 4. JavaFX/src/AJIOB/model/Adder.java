package AJIOB.model;

/**
 * Sums v1 and v2 vectors in many threads
 * <p>
 * Created by AJIOB on 21.03.2017.
 *
 * @author AJIOB
 */
public class Adder {
    private Vector v1 = new Vector();
    private Vector v2 = new Vector();

    /**
     * Set pair of vectors to add. This vectors must be one length
     *
     * @param v1 First new Vector
     * @param v2 Second new Vector
     * @return Are Vector setted by current operation
     */
    public boolean setVectors(final Vector v1, final Vector v2) {
        if (v1.getSize() != v2.getSize()) {
            return false;
        }

        this.v1 = v1;
        this.v2 = v2;

        return true;
    }

    /**
     * Add two vectors that was setted by setVector() method
     *
     * @return Sum
     */
    public Vector add() {
        Vector res = new Vector();
        res.setSize(v1.getSize());

        //todo: adding with threads

        return res;
    }
}
