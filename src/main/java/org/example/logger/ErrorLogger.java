package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LogMessage logMessage, LoggerObservable loggerObservable) {

        loggerObservable.notifyAllObserver(LogLevel.ERROR, logMessage);
    }
}