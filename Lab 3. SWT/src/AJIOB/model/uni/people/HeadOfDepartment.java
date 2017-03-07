package AJIOB.model.uni.people;

import AJIOB.model.uni.teaching.Subject;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class HeadOfDepartment extends Worker {
    HeadOfDepartment(final String name) {
        super(name);
    }

    /**
     * Set exam of subject
     * @param subj Examining subject
     * @return Is exam setted
     */
    public boolean appointExam(final Subject subj) {
        //todo

        return true;
    }
}
