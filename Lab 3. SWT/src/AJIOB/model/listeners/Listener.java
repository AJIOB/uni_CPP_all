package AJIOB.model.listeners;

/**
 * Created by AJIOB on 15.03.2017.
 *
 * @author AJIOB
 */
public interface Listener<E> {
    /**
     * Called when some element is changed
     *
     * @param changedIndex   Index of changed element
     * @param changedElement New version of element
     */
    void SthIsChanged(int changedIndex, final E changedElement);

    /**
     * Called when some element is added
     *
     * @param newElemIndex Index of new element
     * @param newElem      New element
     */
    void SthIsAdd(int newElemIndex, final E newElem);

    /**
     * Called when someting is removed
     *
     * @param oldElemIndex Old index of removed element
     * @param oldElem      Old element
     */
    void SthIsRemoved(int oldElemIndex, final E oldElem);
}
