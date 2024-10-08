package ults;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static Logger Log = LogManager.getLogger(Log.class.getName());

    public static void info (String message) {
        Log.info(message);
    }

    public static void error (String message) {
        Log.error(message);
    }

    public static void debug (String message) {
        Log.debug(message);
    }
    public static void trace (String message) {
        Log.trace(message);
    }

}
