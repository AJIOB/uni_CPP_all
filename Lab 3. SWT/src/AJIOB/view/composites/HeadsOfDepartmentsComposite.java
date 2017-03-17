package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.listeners.Listener;
import AJIOB.model.uni.people.HeadOfDepartment;
import AJIOB.model.uni.people.Worker;
import AJIOB.model.uni.teaching.Subject;
import AJIOB.view.MainShell;
import AJIOB.view.make.AddFewEducatorsShell;
import AJIOB.view.make.AddFewSubjectsShell;
import AJIOB.view.make.AddPersonShell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.util.ArrayList;

/**
 * Created by AJIOB on 08.03.2017.
 */
public class HeadsOfDepartmentsComposite extends Composite {
    private Table subjectTable = null;
    private final ArrayList<HeadOfDepartment> heads = new ArrayList<>();
    private int currentHeadsIndex = -1;

    public HeadsOfDepartmentsComposite(Composite parent, int style) {
        super(parent, style);

        init();
    }

    private void init() {
        RowLayout rLayoutForMain = new RowLayout();
        rLayoutForMain.type = SWT.HORIZONTAL;
        rLayoutForMain.marginWidth = 5;
        rLayoutForMain.spacing = 5;

        setLayout(rLayoutForMain);

        makeHeadsBlock(this);
        makeSubjectBlock(this);
    }

    /**
     * Generating first column as one composite. This column contains list of heads of departments
     *
     * @return Generated composite
     */
    private Composite makeHeadsBlock(Composite parent) {
        Group res = new Group(parent, SWT.NONE);
        res.setText("Heads of departments");
        RowLayout layout = new RowLayout();
        layout.type = SWT.VERTICAL;
        layout.spacing = 5;
        res.setLayout(layout);

        Table mainTable = new Table(res, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);

        TableColumn name = new TableColumn(mainTable, SWT.LEFT);
        name.setText("Name");
        name.setWidth(100);

        try {
            MainShell.getUniversity().getWorkers().stream()
                    .filter(worker -> worker.getJob() == "HeadOfDepartment")
                    .forEach(w -> {
                        TableItem tItem = new TableItem(mainTable, SWT.NONE);
                        tItem.setText(new String[]{w.getName()});

                        heads.add((HeadOfDepartment) w);
                    });

            //add listener if something is happened with this data
            MainShell.getUniversity().addWorkerListener(new Listener<Worker>() {
                @Override
                public void SthIsChanged(int changedIndex, Worker w) {
                    //todo if need
                }

                @Override
                public void SthIsAdd(int newElemIndex, Worker w) {
                    if (w.getJob() != "HeadOfDepartment") {
                        return;
                    }

                    TableItem tItem = new TableItem(mainTable, SWT.NONE);
                    tItem.setText(new String[]{w.getName()});

                    heads.add((HeadOfDepartment) w);
                }

                @Override
                public void SthIsRemoved(int oldElemIndex, Worker oldElem) {
                    //todo if need
                }
            });
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }

        mainTable.addListener(SWT.Selection, event -> {
            int index = mainTable.indexOf((TableItem) event.item);
            refreshSubjectsInfo(heads.get(index));
            currentHeadsIndex = index;
        });

        Button addHOD = new Button(res, SWT.CENTER);
        addHOD.setText("Add new person");
        addHOD.addListener(SWT.Selection, event -> {
            HeadOfDepartment h;
            try {
                h = new HeadOfDepartment(AddPersonShell.run());
                h.getSubjects().addAll(AddFewSubjectsShell.run());
                h.getEducators().addAll(AddFewEducatorsShell.run());

            } catch (NullPointerException e) {
                return;
            }

            try {
                MainShell.getUniversity().addHeadOfDepartmentPerson(h);
            } catch (NoInitException e) {
            }
        });

        return res;
    }

    /**
     * Make second column of tab
     *
     * @param parent Parent composite
     * @return Composite, that was made
     */
    private Composite makeSubjectBlock(Composite parent) {
        Group g = new Group(parent, SWT.FILL);
        g.setText("Select subject to create an exam:");

        RowLayout rLayout = new RowLayout();
        rLayout.type = SWT.VERTICAL;
        rLayout.spacing = 5;
        g.setLayout(rLayout);

        subjectTable = makeSubjectTable(g);

        Button addBtn = new Button(g, SWT.CENTER);
        addBtn.setText("Add exam");
        addBtn.addListener(SWT.Selection, event -> {
            int i = subjectTable.getSelectionIndex();

            if ((i < 0) || (currentHeadsIndex < 0)) {
                return;
            }

            HeadOfDepartment currHead = heads.get(currentHeadsIndex);

            currHead.appointExam(currHead.getSubjects().get(i));
        });

        return g;
    }

    /**
     * Create required Subject table
     *
     * @param c Parent Composite
     * @return Table, that was made
     */
    private Table makeSubjectTable(Composite c) {
        Table t = new Table(c, SWT.SINGLE | SWT.BORDER);
        t.setLayout(new FillLayout());

        TableColumn subjectColumn = new TableColumn(t, SWT.LEFT);
        subjectColumn.setText("Subjects");
        subjectColumn.setWidth(150);

        return t;
    }

    /**
     * Clear and fill again all subjects, which belong to Head of Department
     *
     * @param h Head of Department. Gets info about subjects
     */
    private void refreshSubjectsInfo(HeadOfDepartment h) {
        subjectTable.removeAll();

        if (h == null) {
            return;
        }

        for (Subject subj : h.getSubjects()) {
            TableItem tItem = new TableItem(subjectTable, SWT.LEFT);
            tItem.setText(new String[]{subj.toString()});
        }
    }
}
