package org.dndp.dndc.client.gui.card.description;

import org.dndp.dndc.client.gui.card.CollectionContentProvider;
import org.dndp.dndc.engine.card.description.Race;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

public class RacePicker extends Dialog implements SelectionListener
{
    private class RaceLabelProvider extends LabelProvider
    {
        @Override
        public String getText(Object element)
        {
            return ((Race)element).getName();
        }
    }

    private List       list;
    private ListViewer listViewer;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public RacePicker(Shell parentShell)
    {
        super(parentShell);
        parentShell.setText("Wybur rasy");
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite)super.createDialogArea(parent);

        listViewer = new ListViewer(container, SWT.BORDER | SWT.V_SCROLL);
        listViewer.setLabelProvider(new RaceLabelProvider());
        listViewer.setContentProvider(new CollectionContentProvider());
        list = listViewer.getList();
        list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        list.addSelectionListener(this);

        return container;
    }

    /**
     * Create contents of the button bar.
     * 
     * @param parent
     */
    @Override
    protected void createButtonsForButtonBar(Composite parent)
    {
        createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL,
                true);
        createButton(parent, IDialogConstants.CANCEL_ID,
                IDialogConstants.CANCEL_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize()
    {
        return new Point(450, 300);
    }

    @Override
    public void widgetDefaultSelected(SelectionEvent arg0)
    {
        // FIXME: Implementacja
        throw new UnsupportedOperationException();
    }

    @Override
    public void widgetSelected(SelectionEvent arg0)
    {
        // FIXME: Implementacja
        throw new UnsupportedOperationException();
    }
}
