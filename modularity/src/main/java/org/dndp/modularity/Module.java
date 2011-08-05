/**
 * 
 */
package org.dndp.modularity;


/**
 * Klasa dostarcza wszystkich informacji na temat danego modułu. Niekoniecznie poprawnie
 * załadowanego.
 * 
 * @author evil
 * 
 */
class Module
{
    /**
     * Czy moduł jest włączony.
     */
    private boolean  running;
    /**
     * Z założenia unikalna nazwa modułu.
     * NP: <code>org.dndp.dndc.modules.CUI</code>
     */
    private String   moduleName;
    /**
     * Klasa implementująca Runnable będąca EntryPoint'em. Np:
     * <code>org.dndp.dndc.CUI.Launcher</code>
     */
    private String   entryPoint;
    /**
     * Pełna nazwa pliku jar z EntryPoint (Runnable). Np:
     * <code>/home/evil/.dndp/dndc/modules/CUI-1.2.3.jar</code>
     */
    private String   mainJarFile;
    /**
     * Pełne nazwy plików jar będących zależnościami tego modułu. Mogą one by innymi modułami lub
     * ich zależnościami. Np: <code>{
     * "/home/evil/.dndp/dndc/modules/dndc-2.0.1.jar",
     * "/home/evil/.dndp/dndc/modules/engine-2.1.1.jar"
     * }</code>
     */
    private String[] dependenciesJarFiles;
    /**
     * Wersja tego modułu. Menadżer Aktualizacji wykorzysta to pole aby sprawdzić dostępność
     * ewentualnych aktualizacji. Np: <code>76</code>
     */
    private int      version;
    /**
     * Repozytorium aktualizacji dla tego modułu.
     * Jest to pełna ścieżka łącznie z protokołem (<s>http</s>) np:
     * <code>http://modules.dndc.dndp.org/CUI</code>
     * 
     * @fixme Wybrać protokół
     */
    private String   updateRepository;

    /**
     * Inicjalizuje podstawowymi informacjami o module.
     * 
     * @fixme Ustawić repozytorium aktualizacji dla każdego modułu.
     * @param moduleName Nazwa modułu
     * @param mainJarFile jar z EntryPoint (Runnable)
     */
    public Module(String moduleName, String mainJarFile)
    {
        this.moduleName = moduleName;
        this.mainJarFile = mainJarFile;
        this.running = false;
    }

    /**
     * Konstruktor domyślny.
     * 
     * @fixme THIS IS HACK. Remove when unnecessary.
     */
    public Module()
    {
        this.running = false;
    }

    /**
     * @return the moduleName
     */
    public String getModuleName()
    {
        return this.moduleName;
    }

    /**
     * @return the mainJarFile
     */
    public String getMainJarFile()
    {
        return this.mainJarFile;
    }

    /**
     * @return the dependenciesJarFiles
     */
    public String[] getDependenciesJarFiles()
    {
        return this.dependenciesJarFiles;
    }

    /**
     * @return the version
     */
    public int getVersion()
    {
        return this.version;
    }

    /**
     * @return the updateRepository
     */
    public String getUpdateRepository()
    {
        return this.updateRepository;
    }

    /**
     * @return the entryPoint
     */
    public String getEntryPoint()
    {
        return entryPoint;
    }

    /**
     * @return the running
     */
    public boolean isRunning()
    {
        return this.running;
    }

    /**
     * @param moduleName the moduleName to set
     */
    public void setModuleName(String moduleName)
    {
        this.moduleName = moduleName;
    }

    /**
     * @param mainJarFile the mainJarFile to set
     */
    public void setMainJarFile(String mainJarFile)
    {
        this.mainJarFile = mainJarFile;
    }

    /**
     * @param dependenciesJarFiles the dependenciesJarFiles to set
     */
    public void setDependenciesJarFiles(String[] dependenciesJarFiles)
    {
        this.dependenciesJarFiles = dependenciesJarFiles;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(int version)
    {
        this.version = version;
    }

    /**
     * @param updateRepository the updateRepository to set
     */
    public void setUpdateRepository(String updateRepository)
    {
        this.updateRepository = updateRepository;
    }

    /**
     * @param entryPoint the entryPoint to set
     */
    public void setEntryPoint(String entryPoint)
    {
        this.entryPoint = entryPoint;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running)
    {
        this.running = running;
    }

    /**
     * W klasach pochodnych funkcja ta może zostać wykorzystana w celu dostarczenia dodatkowych
     * informacji o module.
     */
    public void polimorphicParse()
    {
        //DO NOTHING
    }
}
