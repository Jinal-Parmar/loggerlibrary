package org.example.logger;

import org.example.LogMessage;
import org.example.LoggerObservable;
import org.example.enums.LogLevel;

public class WarnLogger extends AbstractLogger {

    public WarnLogger(LogLevel levels) {
        this.level = levels;
    }

    @Override
    protected void display(LogMessage logMessage, LoggerObservable loggerObservable) {

        loggerObservable.notifyAllObserver(LogLevel.WARN, logMessage);
    }
}