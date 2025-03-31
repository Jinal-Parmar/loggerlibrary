package org.example;

import org.example.enums.LogLevel;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getLogger();
        //logger.setConfig(1, "FILE", "app.log");
        // logger.setConfig(LogLevel.INFO, "CONSOLE", "","dd-MM-yyyy HH:mm:ss");
        logger.setConfig(LogLevel.DEBUG, "CONSOLE", "", "");
        test(logger);
        System.out.println("===============");

        logger.setConfig(LogLevel.INFO, "CONSOLE", "", "");
        test(logger);
        System.out.println("===============");

        logger.setConfig(LogLevel.WARN, "CONSOLE", "", "");
        test(logger);
        System.out.println("===============");

        logger.setConfig(LogLevel.ERROR, "CONSOLE", "", "");
        test(logger);
        System.out.println("===============");

        logger.setConfig(LogLevel.FATAL, "CONSOLE", "", "");
        test(logger);
        System.out.println("===============");

        logger.setConfig(LogLevel.INFO, "FILE", "app.log", "");
        for(int i=0;i<1000;i++)
        test(logger);
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