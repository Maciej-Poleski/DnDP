/**
 * Zbiór klas służących do zarządzania modułami klienta. Zakłada się, że każdy
 * moduł posiada w katalogu głównym pliku *.jar plik module.txt zawierający
 * nazwę klasy implementującej Runnable.
 * 
 * Jeżeli wskazana klasa nie implementuje interfejsu Runnable, funkcja dispatch
 * pominie dany moduł i oznaczy go jako uszkodzony.
 * 
 * <b>modules.txt</b>
 * Zdefiniowana jest pierwsza linia - klasa implementująca interfejs Runnable.
 * Zostanie wykonana funkcja run na rzecz tej klasy.
 * 
 * Dalcza częś pliku pozostaje niezdefiniowana. Każdy moduł może umieścić tam dowolną treść. W
 * szczególności może nadpisać metodę Module.polimorphicParse() w celu dostarczenia tych informacji
 * do API.
 */
package org.dndp.modularity;


import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarFile;

/**
 * Klasa statyczna dokonująca wyszukiwania i rejestracji modułów. Dodatkowo dostarcza podstawowych
 * informacji o sprawności modułów i uruchamia wszystkie sprawne.
 * 
 * @author evil
 * 
 */
public class ModulesDispatcher
{
    private static List<Module> registeredModules = null;
    private static List<Module> brokenModules     = null;
    private static boolean      initialized       = false;

    private ModulesDispatcher()
    {}

    /**
     * Przeszukuje podany katalog w poszukiwaniu modułów i próbuje je uruchomić
     * 
     * @param path Pełna nazwa katalogu z modułami
     * @return Lista odnalezionych potencjalnie modułów
     */
    public static List<Module> dispatch(String path) throws NullPointerException
    {
        if(initialized == false)
        {
            registeredModules = new ArrayList<Module>();
            brokenModules = new ArrayList<Module>();
        }
        initialized = true;
        File modulesDirectory = new File(path);
        String modulesFound[] = modulesDirectory.list(new FilenameFilter()
        {
            @Override
            public boolean accept(File dir, String name)
            {
                if(name.toLowerCase().endsWith(".jar")) return true;
                return false;
            }
        });

        if(modulesFound==null)
            return new ArrayList<Module>();

        List<Module> classList = new ArrayList<Module>();

        for(String module : modulesFound)
        {
            try
            {
                JarFile file = new JarFile(module);
                /**
                 * Pozwalam na NullPointerException - do złapania poniżej
                 */
                InputStream stream = file.getInputStream(file.getEntry("module.txt"));
                String className = new BufferedReader(new InputStreamReader(stream)).readLine();
                Module module1 = new Module();
                module1.setEntryPoint(className);
                module1.setMainJarFile(file.getName());
                classList.add(module1);
            }
            catch(Exception e)
            {
                Module module1 = new Module();
                try
                {
                    module1.setMainJarFile(modulesDirectory.getCanonicalPath() + module);
                }
                catch(Exception e1)
                {}
                brokenModules.add(module1);
            }
        }

        for(Module module : classList)
        {
            try
            {
                Runnable moduleToRun =
                    (Runnable) Class.forName(module.getEntryPoint()).newInstance();
                Thread newThread = new Thread(moduleToRun);
                newThread.start();
                module.setRunning(true);
                registeredModules.add(module);
            }
            catch(Exception e)
            {
                brokenModules.add(module);
            }
        }
        return classList;
    }

    /**
     * @return the registeredModules
     */
    public static List<Module> getRegisteredModules()
    {
        return registeredModules;
    }

    /**
     * @return the brokenModules
     */
    public static List<Module> getBrokenModules()
    {
        return brokenModules;
    }

    /**
     * Chwilowo jest to główny EntryPoint platformy.
     * @param args Argumenty przekazane przez stage2 (ścieżka do katalogu głównego aplikacji i platforma)
     */
    public static void main(String... args)
    {
        dispatch(args[0]+"lib");
        dispatch(args[0]+"modules");  // TODO: Uściślić implementacje
    }
}
