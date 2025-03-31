package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public class DebugLogger extends AbstractLogger {

    public DebugLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LogMessage logMessage, LoggerObservable loggerObservable) {

        loggerObservable.notifyAllObserver(LogLevel.DEBUG, logMessage);
    }
}