package org.example;

import org.example.enums.LogLevel;
import org.example.enums.SinkType;
import org.example.enums.WriteMode;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        //logger.setConfig(1, "FILE", "app.log");
        // logger.setConfig(LogLevel.INFO, SinkType.CONSOLE, "","dd-MM-yyyy HH:mm:ss");
        logger.setConfig(LogLevel.DEBUG, SinkType.CONSOLE, "", "",  WriteMode.ASYNC);
        test(logger);
        System.out.println("===============1");

        logger.setConfig(LogLevel.INFO, SinkType.CONSOLE, "", "",  WriteMode.ASYNC);
        test(logger);
        System.out.println("===============2");

        logger.setConfig(LogLevel.WARN, SinkType.CONSOLE, "", "", WriteMode.ASYNC);
        test(logger);
        System.out.println("===============3");

        logger.setConfig(LogLevel.ERROR, SinkType.CONSOLE, "", "",  WriteMode.ASYNC);
        test(logger);
        System.out.println("===============4");

        logger.setConfig(LogLevel.FATAL, SinkType.CONSOLE, "", "", WriteMode.ASYNC);
        test(logger);
        System.out.println("===============5");

        logger.setConfig(LogLevel.INFO, SinkType.FILE, "app.log", "",  WriteMode.SYNC);
        for(int i=0;i<1000;i++)
        test(logger);

        System.out.println("main executed");
        Logger.shutdown();
    }

    private static void test(Logger logger) {
        logger.debug("this is a debug");
        logger.debug("this is a debug2");
        logger.info("this is an info");
        logger.warn("this is warning ");
        logger.error("this is an error");
        logger.fatal("this is an fatal");
    }


    private static void testDebugLevel(Logger logger) {
        logger.debug("this is a debug");
        logger.debug("this is a debug2");
        logger.info("this is an info");
        logger.warn("this is warning ");
        logger.error("this is an error");
        logger.fatal("this is an fatal");
    }


}