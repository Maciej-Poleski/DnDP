package org.dndp.dndc.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.dndp.dndc.client.gui.MainWindow;
import org.eclipse.swt.widgets.Display;

/**
 * Najważniejsza klasa w programie.
 * 
 * @par TODO Na koniec przejrzeć i sprawdzić inicjalizację Zrobić jak należy @code
 *      run() @endcode czyli shutdown hook uruchamiający closeConnection w
 *      handle
 * @author bambucha
 */
public class Main extends Thread
{
    private MainWindow window;

    // FIXME: Stowrzyć faktyczny szkielet aplikacji.
    public Main()
    {}

    @Override
    public void run()
    {
        window = new MainWindow();
        window.setBlockOnOpen(true);
        window.open();
        Display.getCurrent().dispose();
    }

    /**
     * Funkcja zachowana dla kompatybilności wstecz.
     * Oddelegowuje zadanie uruchomienia klienta do modularity.
     * @param args
     */
    public static void main(String[] args)
    {
        Logger.getLogger("").setLevel(Level.WARNING);
//        new Main().start();  // Ten moduł zostanie uruchomiony przez ModuledDispatchera
        org.dndp.modularity.ModulesDispatcher.main(args);
        // Ta instrukcja tworzy jedyne silne wiązanie do modularity i powoduje, że staje się on zależnością.
    }

}
