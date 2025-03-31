package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public abstract class AbstractLogger {
    LogLevel level;
    private AbstractLogger nextLevelLogger;

    public void setNextLevelLogger(AbstractLogger nextLevelLogger) {
        this.nextLevelLogger = nextLevelLogger;
    }

    public void logMessage(LogMessage logMessage, LoggerObservable loggerObservable) {
        if (this.level == logMessage.getLogLevel()) {
            display(logMessage, loggerObservable);
        }

        if (nextLevelLogger != null) {
            nextLevelLogger.logMessage(logMessage, loggerObservable);
        }
    }

    protected abstract void display(LogMessage logMessage, LoggerObservable loggerObservable);
}