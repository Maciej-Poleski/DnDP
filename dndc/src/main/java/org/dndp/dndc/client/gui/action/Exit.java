package org.dndp.dndc.client.gui.action;

import java.io.File;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.ApplicationWindow;

public class Exit extends Action
{
    private ApplicationWindow window;
    private File              autosave;

    public Exit(ApplicationWindow window)
    {
        this.window = window;
        setText("Wyjśćie");
        autosave = new File("autosave.ch");
    }

    @Override
    public void run()
    {

        Dialog d = new ExitQuestionDialog(window.getShell());
        if(d.open())
            if(autosave.exists())

                window.close();

    }
}
