package org.dndp.dnds;

import static java.lang.Math.ceil;
import static java.lang.Math.random;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Logger;

import com.db4o.ObjectServer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ServerConfiguration;

public class SimpleServer extends Thread
{
    private static final Logger log     = Logger.getLogger("database-insert");

    private static final int    port    = 31116;
    private static final String name    = "database.db";
    private static final String user    = "dndp";
    private static final String pass    = "NieDlaRobotów";

    private static final String logfile = "db.log";

    private ServerConfiguration conf;
    private ObjectServer        server;

    public SimpleServer()
    {
        conf = Db4oClientServer.newServerConfiguration();
        conf.common().messageLevel(2);
        conf.common().exceptionsOnNotStorable(false);
        try
        {
            conf.common().outStream(new PrintStream(new File(logfile)));
        }
        catch(FileNotFoundException e)
        {
            java.util.logging.Logger.getLogger(SimpleServer.class.getName())
                    .log(java.util.logging.Level.SEVERE, "Wyjątek", e);
        }
        // conf.common().callConstructors(false);

        log.info("Config stworzony");
        server = Db4oClientServer.openServer(conf, name, port);
        server.grantAccess(user, pass);
    }

    @Override
    public void run()
    {
        super.run();

        log.info("server pracuje");

        while(true)
        {
            try
            {
                Thread.sleep((int)ceil(random() * 10));

            }
            catch(InterruptedException e)
            {}
        }
    }

    public static void main(String[] args)
    {
        new SimpleServer().start();
    }
}
