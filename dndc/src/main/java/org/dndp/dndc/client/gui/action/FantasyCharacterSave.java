package org.dndp.dndc.client.gui.action;

import java.io.File;

import org.dndp.dndc.client.gui.MainWindow;
import org.dndp.dndc.engine.FantasyCharacter;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.FileDialog;

public class FantasyCharacterSave extends Action
{
    private MainWindow window;

    public FantasyCharacterSave(MainWindow window)
    {
        this.window = window;
    }

    @Override
    public void run()
    {
        super.run();
        FileDialog dialog = new FileDialog(window.getShell());
        File dest = new File(dialog.open());
        FantasyCharacter.store(dest, window.getFantasyCharacter());
    }

}
