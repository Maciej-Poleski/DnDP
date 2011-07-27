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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

/**
 * Klasa do wi
 * 
 * @author bambucha
 * 
 */
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
    public ClassesView(Composite parent, int style, CharacterClassManager model)
    {
        super(parent, SWT.NONE);

        setText("Klasy");
        GridLayout gridLayout = new GridLayout(6, false);
        gridLayout.marginTop = 5;
        setLayout(gridLayout);

        listViewer = new ListViewer(this, SWT.BORDER | SWT.V_SCROLL);
        listViewer.setLabelProvider(new ClassLabelProvider());
        listViewer.setContentProvider(new CollectionContentProvider());
        listViewer.addSelectionChangedListener(this);
        List listView = listViewer.getList();
        listView.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2,
                2));

        Group grpSzczegy = new Group(this, SWT.NONE);
        grpSzczegy.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false,
                3, 2));
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
        sumText.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false,
                false, 1, 1));

        Label lblDowiadczenie = new Label(this, SWT.CENTER);
        lblDowiadczenie.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
                false, 1, 1));
        lblDowiadczenie.setText("Doświadczenie");

        experienceText = new Text(this, SWT.BORDER);
        experienceText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false,
                false, 1, 1));

        Label lblSkala = new Label(this, SWT.CENTER);
        lblSkala.setText("Kara");

        pentlyText = new Text(this, SWT.BORDER);

        Label lblNastpnyPoziom = new Label(this, SWT.CENTER);
        lblNastpnyPoziom.setText("Następny poziom");

        nextLevelText = new Text(this, SWT.BORDER);

        setModel(model);

    }

    /**
     * Liczy doświadczenie potrzebne na nowy poziom.
     * 
     * @param level
     *            poziom
     * @return potrzebne doświadczenie
     */
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

    public void setModel(CharacterClassManager model)
    {
        model.addCharacterClassObserver(this);
    }
}
