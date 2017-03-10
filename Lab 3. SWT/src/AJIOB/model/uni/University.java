package AJIOB.model.uni;

import AJIOB.model.uni.books.GradeBook;
import AJIOB.model.uni.buildings.Building;
import AJIOB.model.uni.people.*;
import AJIOB.model.uni.teaching.Exam;
import AJIOB.model.uni.teaching.Subject;

import java.util.ArrayList;

/**
 * Created by AJIOB on 07.03.2017.
 */
public class University implements Building {
    private final String name;

    private final double length;
    private final double width;

    private ArrayList<Worker> workers = new ArrayList<>();
    private ArrayList<Subject> subjects = new ArrayList<>();
    private ArrayList<Exam> exams = new ArrayList<>();
    private ArrayList<GradeBook> gradeBooks = new ArrayList<>();
    private ArrayList<Student> students = new ArrayList<>();

    public University(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;

        fillContainers();
    }

    private void fillContainers() {
        //for test only
        workers.add(new HeadOfDepartment("Alex"));
        workers.add(new Educator("Petr"));
        workers.add(new Educator("Edu"));
        workers.add(new HeadOfDepartment("Ivan"));

        exams.add(new Exam(new Subject("S1_test"), new Educator("Sergey"), null));
        exams.add(new Exam(new Subject("S2_test"), new Educator("Daria"), null));
    }

    @Override
    public double getSquare() {
        return length * width;
    }

    /**
     * Enroll new student
     *
     * @param futureStudent Person that will be a student
     */
    public void enrollStudent(Person futureStudent) {
        //TODO
    }

    /**
     * Make new record book for student
     *
     * @return New record book
     */
    public GradeBook getNewRecordBook() {
        //TODO
        return new GradeBook(null);
    }

    /**
     * Making exam (and adding it in schedule)
     *
     * @param subj Subject, that students will pass
     * @return New exam
     */
    public Exam createExam(final Subject subj) {
        //TODO
        return new Exam(new Subject(""), null, null);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Exam> getExams() {
        return exams;
    }

    public ArrayList<GradeBook> getGradeBooks() {
        return gradeBooks;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public ArrayList<Worker> getWorkers() {
        return workers;
    }
}
