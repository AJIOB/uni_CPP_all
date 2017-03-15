package AJIOB.model.listeners;

import java.util.ArrayList;

/**
 * Created by AJIOB on 15.03.2017.
 *
 * @author AJIOB
 */
public class MakeOperation {
    /**
     * Call SthIsAdd in all listeners
     *
     * @param listeners Array of listeners, which methods will call
     * @param list      List, where add will be called
     * @param element   Element to add (second parameter of SthIsAdd)
     * @param <E>       What type listeners is listen
     */
    public static <E> void add(final ArrayList<Listener<E>> listeners, final ArrayList<E> list, final E element) {
        if (list.add(element)) {
            for (Listener<E> l : listeners) {
                l.SthIsAdd(list.indexOf(element), element);
            }
        }
    }

    /**
     * Call SthIsChanged in all listeners
     *
     * @param listeners Array of listeners, which methods will call
     * @param index     Index of changed element (first parameter of SthIsChanged)
     * @param element   New version of changed element (second parameter of SthIsChanged)
     * @param <E>       What type listeners is listen
     */
    public static <E> void callChanged(final ArrayList<Listener<E>> listeners, int index, final E element) {
        for (Listener<E> l : listeners) {
            l.SthIsChanged(index, element);
        }
    }

    /**
     * Call SthIsRemoved in all listeners
     *
     * @param listeners Array of listeners, which methods will call
     * @param list      List, where remove will be called
     * @param element   Removed element (second parameter of SthIsRemoved)
     * @param <E>       What type listeners is listen
     */
    public static <E> void remove(final ArrayList<Listener<E>> listeners, final ArrayList<E> list, final E element) {
        int index = list.indexOf(element);
        if (index < 0) {
            return;
        }

        E obj = list.remove(index);

        for (Listener<E> l : listeners) {
            l.SthIsRemoved(index, obj);
        }
    }

    /**
     * Call SthIsRemoved in all listeners
     *
     * @param listeners Array of listeners, which methods will call
     * @param list      List, where remove will be called
     * @param index     Index of element need to remove
     * @param <E>       What type listeners is listen
     */
    public static <E> boolean remove(final ArrayList<Listener<E>> listeners, final ArrayList<E> list, final int index) {
        E obj;

        try {
            obj = list.remove(index);
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        for (Listener<E> l : listeners) {
            l.SthIsRemoved(index, obj);
        }

        return true;
    }
}
