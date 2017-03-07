package AJIOB.model.uni.teaching;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class Mark {
    private int mark;
    private Subject subject;

    Mark(final int mark, final Subject subject) {
        this.mark = mark;
        this.subject = subject;
    }

    /**
     * Get mark as int
     * @return mark
     */
    public int mark() {
        return mark;
    }

    /**
     * Get subject, which what is that mark belongs
     * @return subject
     */
    public Subject subject() {
        return subject;
    }
}
