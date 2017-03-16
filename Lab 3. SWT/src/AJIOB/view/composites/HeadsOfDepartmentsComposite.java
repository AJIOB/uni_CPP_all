package AJIOB.view.composites;

import AJIOB.exceptions.NoInitException;
import AJIOB.model.uni.people.HeadOfDepartment;
import AJIOB.model.uni.people.Worker;
import AJIOB.model.uni.teaching.Subject;
import AJIOB.view.MainShell;
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

    public HeadsOfDepartmentsComposite(Composite parent, int style) {
        super(parent, style);

        init();
    }

    private void init() {
        RowLayout rLayoutForMain = new RowLayout();
        rLayoutForMain.type = SWT.HORIZONTAL;
        rLayoutForMain.marginWidth = 5;
        rLayoutForMain.spacing = 5;
        //rLayoutForMain.pack = false;

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
/*
        Label headText = new Label(res, SWT.LEFT | SWT.HORIZONTAL);
        headText.setText("Heads of departments");*/

        Table mainTable = new Table(res, SWT.SINGLE | SWT.BORDER | SWT.FULL_SELECTION);

        TableColumn name = new TableColumn(mainTable, SWT.LEFT);
        name.setText("Name");
        name.setWidth(100);

        try {
            for (Worker w : MainShell.getUniversity().getWorkers()) {
                if (w.getJob() == "HeadOfDepartment") {
                    TableItem tItem = new TableItem(mainTable, SWT.NONE);
                    tItem.setText(new String[]{w.getName()});

                    heads.add((HeadOfDepartment) w);
                }
            }
        } catch (NoInitException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {

        }

        mainTable.addListener(SWT.Selection, event -> {
            int index = mainTable.indexOf((TableItem) event.item);
            refreshSubjectsInfo(heads.get(index));
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
            //TODO
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
