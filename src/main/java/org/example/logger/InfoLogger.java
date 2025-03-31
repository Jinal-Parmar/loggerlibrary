package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public class InfoLogger extends AbstractLogger {

    public InfoLogger(LogLevel levels) {
        this.level = levels;
    }

    @Override
    protected void display(LogMessage logMessage, LoggerObservable loggerObservable) {

        loggerObservable.notifyAllObserver(LogLevel.INFO, logMessage);
    }
}