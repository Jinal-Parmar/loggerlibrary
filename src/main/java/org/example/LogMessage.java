package org.example;

import org.example.enums.LogLevel;

public class LogMessage {
    private String message;
    private LogLevel logLevel;
    private String nameSpace;

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }


    public LogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LogMessage(String message, LogLevel logLevel) {
        this.message = message;
        this.logLevel = logLevel;
        this.nameSpace = "org.example";
    }

    @Override
    public String toString() {
        return String.format("[%s] [%s] [%s] - %s", logLevel, nameSpace, getCurrentTimestamp(), message);
    }

    private String getCurrentTimestamp() {
        return java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern(LoggerConfig.timeFormat));
    }
}
