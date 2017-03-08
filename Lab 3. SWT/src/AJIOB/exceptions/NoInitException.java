package AJIOB.exceptions;

/**
 * Created by AJIOB on 08.03.2017.
 *
 * @author AJIOB
 */
public class NoInitException extends Exception {
    public NoInitException() {
        super("Class is not initialased");
    }
}
