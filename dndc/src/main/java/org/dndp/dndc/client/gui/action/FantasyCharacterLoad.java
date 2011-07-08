package org.dndp.dndc.client.gui.action;

import java.io.File;

import org.dndp.dndc.client.gui.MainWindow;
import org.dndp.dndc.engine.FantasyCharacter;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.widgets.FileDialog;

public class FantasyCharacterLoad extends Action
{
    private MainWindow window;

    public FantasyCharacterLoad(MainWindow window)
    {
        this.window = window;
        setText("Wczytaj");
    }

    @Override
    public void run()
    {
        super.run();
        FileDialog dialog = new FileDialog(window.getShell());
        File dest = new File(dialog.open());
        window.setFantasyCharacter(FantasyCharacter.load(dest));
    }

}
