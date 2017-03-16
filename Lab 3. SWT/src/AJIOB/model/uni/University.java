package AJIOB.model.uni;

import AJIOB.model.listeners.Listener;
import AJIOB.model.listeners.MakeOperation;
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

    private final ArrayList<Listener<Worker>> workerListeners = new ArrayList<>();
    private final ArrayList<Listener<Subject>> subjectListeners = new ArrayList<>();
    private final ArrayList<Listener<Exam>> examListeners = new ArrayList<>();
    private final ArrayList<Listener<GradeBook>> gradeBooksListeners = new ArrayList<>();
    private final ArrayList<Listener<Student>> studListeners = new ArrayList<>();

    public University(String name, double length, double width) {
        this.name = name;
        this.length = length;
        this.width = width;

        fillContainers();
    }

    private void fillContainers() {
        //for test only (no calling listeners)
        Educator[] eduTEMP = new Educator[3];
        eduTEMP[0] = new Educator("Dmitriy");
        eduTEMP[1] = new Educator("Petr");
        eduTEMP[2] = new Educator("Irina");

        Subject[] subjTEMP = new Subject[3];
        subjTEMP[0] = new Subject("Math");
        subjTEMP[1] = new Subject("Physics");
        subjTEMP[2] = new Subject("Programming");

        HeadOfDepartment[] headTEMP = new HeadOfDepartment[2];
        headTEMP[0] = new HeadOfDepartment("Alex");
        headTEMP[0].getEducators().add(eduTEMP[0]);
        headTEMP[0].getEducators().add(eduTEMP[2]);
        headTEMP[0].addSubject(subjTEMP[0]);
        headTEMP[0].addSubject(subjTEMP[2]);
        headTEMP[1] = new HeadOfDepartment("Ivan");
        headTEMP[1].getEducators().add(eduTEMP[1]);
        headTEMP[1].addSubject(subjTEMP[1]);

        workers.add(headTEMP[0]);
        workers.add(eduTEMP[0]);
        workers.add(eduTEMP[1]);
        workers.add(headTEMP[1]);

        enrollStudent(new Person("Maria"));
        enrollStudent(new Person("Valentin"));
        enrollStudent(new Person("Anton"));

        exams.add(new Exam(subjTEMP[0], eduTEMP[0], new Student[]{students.get(0), students.get(2)}));
        exams.add(new Exam(subjTEMP[1], eduTEMP[1], new Student[]{students.get(1), students.get(2)}));
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
        MakeOperation.add(studListeners, students, new Student(futureStudent, getNewGradeBook(futureStudent)));
    }

    /**
     * Make new record book for student
     *
     * @param person Person, who will getNewShell this record book
     * @return New record book
     */
    private GradeBook getNewGradeBook(Person person) {
        GradeBook gb = new GradeBook(person);

        MakeOperation.add(gradeBooksListeners, gradeBooks, gb);

        return gb;
    }

    /**
     * Making exam (and adding it in schedule)
     *
     * @param subj Subject, that students will pass
     * @return New exam
     */
    public Exam createExam(final Subject subj, final Educator educator) {
        //convert ArrayList to Array[]
        Student[] studArray = new Student[students.size()];
        studArray = students.toArray(studArray);

        Exam newExam = new Exam(subj, educator, studArray);

        MakeOperation.add(examListeners, exams, newExam);

        return newExam;
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

    public void addWorkerListener(Listener<Worker> listener) {
        workerListeners.add(listener);
    }

    public void addSubjectListener(Listener<Subject> listener) {
        subjectListeners.add(listener);
    }

    public void addExamListener(Listener<Exam> listener) {
        examListeners.add(listener);
    }

    public void addGradeBookListener(Listener<GradeBook> listener) {
        gradeBooksListeners.add(listener);
    }

    public void addStudentListener(Listener<Student> listener) {
        studListeners.add(listener);
    }

    public void removeExam(Exam e) {
        MakeOperation.remove(examListeners, exams, e);
    }
}
