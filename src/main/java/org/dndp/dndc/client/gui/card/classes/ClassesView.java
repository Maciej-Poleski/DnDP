package org.dndp.dndc.client.gui.card.classes;

import java.util.Observable;
import java.util.Observer;

import org.dndp.dndc.engine.card.classes.CharacterClassManager;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Text;

public class ClassesView extends Group implements Observer
{
    private Text text;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;
    private Text text_5;
    private ListViewer listViewer;

    /**
     * Create the composite.
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
        listViewer.setContentProvider(new ClassContentProvider());
        List list = listViewer.getList();
        list.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
        
        
        Group grpSzczegy = new Group(this, SWT.NONE);
        grpSzczegy.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 2));
        grpSzczegy.setText("Szczegóły");
        grpSzczegy.setLayout(new GridLayout(2, false));
        
        Label lblNazwa = new Label(grpSzczegy, SWT.NONE);
        lblNazwa.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNazwa.setText("Nazwa");
        
        text = new Text(grpSzczegy, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblPoziom = new Label(grpSzczegy, SWT.NONE);
        lblPoziom.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblPoziom.setText("Poziom");
        
        text_1 = new Text(grpSzczegy, SWT.BORDER);
        text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Label lblSuma = new Label(this, SWT.NONE);
        lblSuma.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
        lblSuma.setText("Suma");
        
        text_2 = new Text(this, SWT.BORDER);
        text_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Composite composite = new Composite(this, SWT.NONE);
        composite.setLayout(new FillLayout(SWT.HORIZONTAL));
        composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true, 3, 1));
        
        Label lblDowiadczenie = new Label(composite, SWT.CENTER);
        lblDowiadczenie.setText("Doświadczenie");
        
        text_3 = new Text(composite, SWT.BORDER);
        
        Label lblSkala = new Label(composite, SWT.CENTER);
        lblSkala.setText("Kara");
        
        text_4 = new Text(composite, SWT.BORDER);
        
        Label lblNastpnyPoziom = new Label(composite, SWT.CENTER);
        lblNastpnyPoziom.setText("Następny poziom");
        
        text_5 = new Text(composite, SWT.BORDER);

    }
    
    
    
    @Override
    public void update(Observable o, Object arg)
    {
        if(o instanceof CharacterClassManager)
        {
            CharacterClassManager tmp = (CharacterClassManager)o;
            listViewer.setInput(tmp.getClassList());
        }
    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
