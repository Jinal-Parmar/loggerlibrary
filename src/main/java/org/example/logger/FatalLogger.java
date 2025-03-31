package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public class FatalLogger extends AbstractLogger {

    public FatalLogger(LogLevel level) {
        this.level = level;
    }

    @Override
    protected void display(LogMessage logMessage, LoggerObservable loggerObservable) {

        loggerObservable.notifyAllObserver(LogLevel.FATAL, logMessage);
    }
}