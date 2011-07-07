package org.dndp.dnds;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.db4o.cs.Db4oClientServer;

public class SimpleServerTest
{
    private static final int    port    = 31116;
    private static final String name    = "database.db";
    private static final String logfile = "db.log";

    @BeforeClass
    public static void prepare()
    {
        new SimpleServer().start();
    }

    @AfterClass
    public static void clean()
    {
        new File(name).delete();
        new File(logfile).delete();
    }

    @Test
    public void testRun()
    {

        assertTrue(new File(name).exists());
        assertNotNull(Db4oClientServer.openClient("localhost", port, "dndp",
                "NieDlaRobotów"));
    }

    @Test
    public void testLoger()
    {
        assertTrue(new File(logfile).exists());
    }
}
