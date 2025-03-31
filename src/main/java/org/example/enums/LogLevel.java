package org.example.enums;

public enum LogLevel {
    DEBUG(0), INFO(1), WARN(2), ERROR(3), FATAL(4);

    int level;

    LogLevel(int level) {
        this.level = level;
    }

    public int getLevelVal() {
        return this.level;
    }

    public static LogLevel getLogLevel(int level) {
        for (LogLevel cur : LogLevel.values()) {
            if (cur.getLevelVal() == level) {
                return cur;
            }
        }
        throw new IllegalArgumentException("invalid log level" + level);
    }
}