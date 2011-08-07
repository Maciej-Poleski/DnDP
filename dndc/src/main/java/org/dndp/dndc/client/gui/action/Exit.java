package org.dndp.dndc.client.gui.action;

import java.io.File;

import org.dndp.dndc.client.gui.MainWindow;
import org.dndp.dndc.engine.FantasyCharacter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.Dialog;

public class Exit extends Action
{
    private MainWindow window;

    public Exit(MainWindow window)
    {
        this.window = window;
        setText("Wyjśćie");
    }

    @Override
    public void run()
    {

        ExitQuestionDialog d = new ExitQuestionDialog(window.getShell());
        if(d.open() == Dialog.OK)
        {
            File path = new File(d.getResult());
            FantasyCharacter.store(path, window.getFantasyCharacter());
        }
        else
            return;
        window.close();

    }
}
