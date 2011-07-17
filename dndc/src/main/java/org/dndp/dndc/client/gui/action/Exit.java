package org.dndp.dndc.client.gui.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.window.ApplicationWindow;

public class Exit extends Action
{
    private ApplicationWindow window;

    public Exit(ApplicationWindow window)
    {
        this.window = window;
        setText("Wyjśćie");
    }

    @Override
    public void run()
    {
        window.close();
    }
}
