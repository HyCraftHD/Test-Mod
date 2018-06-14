package net.hycrafthd.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestConstants {

    public static final String MODID = "testmod";
    public static final String NAME = "Test Mod";
    public static final String VERSION = "1.0.0";
    public static final String MCVERSION = "1.12.2";

    public static final Logger LOGGER = LogManager.getLogger(NAME);

    public static final String COMMONPROXY = "net.hycrafthd.testmod.proxy.CommonProxy";
    public static final String CLIENTPROXY = "net.hycrafthd.testmod.proxy.ClientProxy";

    private TestConstants (){}
}
