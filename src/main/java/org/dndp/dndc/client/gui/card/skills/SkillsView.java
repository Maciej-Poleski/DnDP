package org.dndp.dndc.client.gui.card.skills;

import org.dndp.dndc.client.gui.card.CollectionContentProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Text;

public class SkillsView extends Group
{
    private Table table;
    private Text maxRankText;

    /**
     * Create the composite.
     * @param parent
     * @param style
     */
    public SkillsView(Composite parent, int style)
    {
        super(parent, style);
        setText("Umiejętności");
        setLayout(new GridLayout(2, false));
        
        TableViewer tableViewer = new TableViewer(this, SWT.BORDER | SWT.FULL_SELECTION);
        tableViewer.setContentProvider(new CollectionContentProvider());
        tableViewer.setLabelProvider(new SklilLabelProvider());
        table = tableViewer.getTable();
        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        
        Label lblMaksymalnaIloRang = new Label(this, SWT.NONE);
        lblMaksymalnaIloRang.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblMaksymalnaIloRang.setText("Maksymalna iloś rang");
        
        maxRankText = new Text(this, SWT.BORDER);
        maxRankText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

    }

    @Override
    protected void checkSubclass()
    {
        // Disable the check that prevents subclassing of SWT components
    }
}
