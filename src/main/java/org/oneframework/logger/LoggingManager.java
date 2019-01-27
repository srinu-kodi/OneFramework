package org.oneframework.logger;

import java.util.logging.Logger;

public class LoggingManager {
    public static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void logMessage(String message) {
        logger.info(message);
    }

}
