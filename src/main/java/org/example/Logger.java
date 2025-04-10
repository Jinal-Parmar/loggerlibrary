package org.example;

import org.example.enums.LogLevel;
import org.example.enums.SinkType;
import org.example.logger.AbstractLogger;

import java.io.Serializable;

import static org.example.LoggerConfig.doChaining;

public class Logger implements Cloneable, Serializable {
    private volatile static Logger logger;
    private volatile static AbstractLogger chainOfLogger;
    private volatile static LoggerObservable loggerObservable;
    private static LoggerConfig loggerConfig;

    private Logger() {
        if (logger != null)
            throw new IllegalStateException("Object already created");
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                    chainOfLogger = doChaining();
                    loggerObservable = new LoggerObservable();
                    loggerConfig = new LoggerConfig(LogLevel.DEBUG, SinkType.CONSOLE, loggerObservable);
                }
            }
        }
        return logger;
    }

    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    protected Object readResolve() {
        return logger;
    }

    public void debug(String message) {
        createLog(LogLevel.DEBUG, message);
    }

    public void info(String message) {
        createLog(LogLevel.INFO, message);
    }

    public void warn(String message) {
        createLog(LogLevel.WARN, message);
    }

    public void error(String message) {
        createLog(LogLevel.ERROR, message);
    }

    public void fatal(String message) {
        createLog(LogLevel.FATAL, message);
    }

    public void setConfig(LogLevel level, SinkType sinkType, String filePath, String timeFormat) {
        LoggerConfig.updateConfig(level, filePath, sinkType, timeFormat);
    }

    private void createLog(LogLevel level, String message) {
        LogMessage logMessage = new LogMessage(message, level);
        chainOfLogger.logMessage(logMessage, loggerObservable);
    }
}