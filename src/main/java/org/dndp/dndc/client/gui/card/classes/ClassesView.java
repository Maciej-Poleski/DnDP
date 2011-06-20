package org.dndp.dndc.client.gui.card.classes;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.client.gui.card.CollectionContentProvider;
import org.dndp.dndc.engine.card.classes.CharacterClass;
import org.dndp.dndc.engine.card.classes.CharacterClassManager;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class ClassesView extends Group implements Observer,
        ISelectionChangedListener
{
    private Text       classNameText;
    private Text       classLevelText;
    private Text       sumText;
    private Text       experienceText;
    private Text       pentlyText;
    private Text       nextLevelText;
    private ListViewer listViewer;

    /**
     * Create the composite.
     * 
     * @param parent
     * @param style
     */
    public ClassesView(Composite parent, int style)
    {
        super(parent, SWT.NONE);
        setText("Klasy");
        setLayout(new GridLayout(3, false));

        listViewer = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
        listViewer.setLabelProvider(new ClassLabelProvider());
        listViewer.setContentProvider(new CollectionContentProvider());
        listViewer.addSelectionChangedListener(this);
        List listView = listViewer.getList();
        listView.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false,
                1, 2));

        Group grpSzczegy = new Group(this, SWT.NONE);
        grpSzczegy.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
                false, 1, 2));
        grpSzczegy.setText("Szczegóły");
        grpSzczegy.setLayout(new GridLayout(2, false));

        Label lblNazwa = new Label(grpSzczegy, SWT.NONE);
        lblNazwa.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
                false, 1, 1));
        lblNazwa.setText("Nazwa");

        classNameText = new Text(grpSzczegy, SWT.BORDER);
        classNameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        Label lblPoziom = new Label(grpSzczegy, SWT.NONE);
        lblPoziom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false,
                false, 1, 1));
        lblPoziom.setText("Poziom");

        classLevelText = new Text(grpSzczegy, SWT.BORDER);
        classLevelText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true,
                false, 1, 1));

        Label lblSuma = new Label(this, SWT.NONE);
        lblSuma.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
                false, 1, 1));
        lblSuma.setText("Suma");

        sumText = new Text(this, SWT.BORDER);
        sumText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
                1, 1));

        Composite composite = new Composite(this, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.HORIZONTAL));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 3,
                1));

        Label lblDowiadczenie = new Label(composite, SWT.CENTER);
        lblDowiadczenie.setText("Doświadczenie");

        experienceText = new Text(composite, SWT.BORDER);

        Label lblSkala = new Label(composite, SWT.CENTER);
        lblSkala.setText("Kara");

        pentlyText = new Text(composite, SWT.BORDER);

        Label lblNastpnyPoziom = new Label(composite, SWT.CENTER);
        lblNastpnyPoziom.setText("Następny poziom");

        nextLevelText = new Text(composite, SWT.BORDER);

    }

    private int getXPForLevel(int level)
    {
        return (level * (level + 1)) / 2;
    }

    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof CharacterClassManager)
        {
            CharacterClassManager tmp = (CharacterClassManager)o;
            listViewer.setInput(tmp.getClassList());
            experienceText.setText(tmp.getExperiancePoint().toString());
            pentlyText.setText(Boolean.toString(tmp.isMultiClassCharacter()));
            sumText.setText(tmp.getLevel().toString());
            nextLevelText
                    .setText(Integer.toString(getXPForLevel(tmp.getLevel())));
        }
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }

    @Override
    public void selectionChanged(SelectionChangedEvent arg0)
    {
        ISelection selection = arg0.getSelection();
        if(selection.isEmpty())
            return;
        else
        {
            CharacterClass tmp = (CharacterClass)((IStructuredSelection)selection)
                    .getFirstElement();
            classNameText.setText(tmp.getClasses().getName());
            classLevelText.setText(tmp.getLevel().toString());
        }
    }
}
