package AJIOB.model.uni.people;

/**
 * Created by AJIOB on 07.03.2017.
 */
abstract public class Worker extends Person {
    private String job;

    public Worker(String name) {
        super(name);
    }

    /**
     * Set current job of worker
     * @param job Name of job
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }
}
