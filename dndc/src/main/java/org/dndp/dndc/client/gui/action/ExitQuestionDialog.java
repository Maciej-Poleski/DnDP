package org.dndp.dndc.client.gui.action;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class ExitQuestionDialog extends Dialog
{
    private Label  lblNewLabel;
    private Text   text;
    private Button btnNewButton;
    private String path;

    /**
     * Create the dialog.
     * 
     * @param parentShell
     */
    public ExitQuestionDialog(Shell parentShell)
    {
        super(parentShell);
    }

    /**
     * Create contents of the dialog.
     * 
     * @param parent
     */
    @Override
    protected Control createDialogArea(final Composite parent)
    {
        Composite container = (Composite)super.createDialogArea(parent);
        container.setLayout(new GridLayout(3, false));

        lblNewLabel = new Label(container, SWT.NONE);
        lblNewLabel.setAlignment(SWT.CENTER);
        GridData gd_lblNewLabel = new GridData(SWT.CENTER, SWT.CENTER, false,
                false, 1, 1);
        gd_lblNewLabel.widthHint = 44;
        lblNewLabel.setLayoutData(gd_lblNewLabel);
        lblNewLabel.setText("Plik");

        text = new Text(container, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnNewButton = new Button(container, SWT.NONE);
        btnNewButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false,
                true, 1, 1));
        btnNewButton.setText("Przeglądaj");

        btnNewButton.addSelectionListener(new SelectionAdapter()
        {
            @Override
            public void widgetSelected(SelectionEvent arg0)
            {
                FileDialog d = new FileDialog(parent.getShell());
                text.setText(d.open());
                path = text.getText();
            }
        });

        File defaultPath = new File("autosave.cha");
        text.setText(defaultPath.getAbsolutePath());
        path = defaultPath.getAbsolutePath();

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
        createButton(parent, IDialogConstants.ABORT_ID,
                IDialogConstants.ABORT_LABEL, false);
    }

    /**
     * Return the initial size of the dialog.
     */
    @Override
    protected Point getInitialSize()
    {
        return new Point(388, 122);
    }

    @Override
    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Zapisywanie Postaci");
    }

    public String getResult()
    {
        return path;
    }
}
