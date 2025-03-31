package org.example;

import org.example.enums.LogLevel;
import org.example.enums.SinkType;
import org.example.logger.*;
import org.example.sink.SinkObserver;

public class LoggerConfig {

    private static LogLevel level;
    private static String sinkType;
    private static LoggerObservable loggerObservable;
    public static String timeFormat = "yyyy-MM-dd HH:mm:ss";


    public LoggerConfig(LogLevel level, String sinkType, LoggerObservable logObservable) {
        this.sinkType = sinkType;
        this.level = level;
        this.loggerObservable = logObservable;
        addObservers(level, sinkType, "", logObservable);
    }

    static AbstractLogger doChaining() {

        AbstractLogger debugLogger = new DebugLogger(LogLevel.DEBUG);
        AbstractLogger infoLogger = new InfoLogger(LogLevel.INFO);
        AbstractLogger warnLogger = new WarnLogger(LogLevel.WARN);
        AbstractLogger errorLogger = new ErrorLogger(LogLevel.ERROR);
        AbstractLogger fatalLogger = new FatalLogger(LogLevel.FATAL);

        debugLogger.setNextLevelLogger(infoLogger);
        infoLogger.setNextLevelLogger(warnLogger);
        warnLogger.setNextLevelLogger(errorLogger);
        errorLogger.setNextLevelLogger(fatalLogger);

        return debugLogger;
    }

    static void updateConfig(LogLevel level, String filePath, String sinkType, String timeFormat) {
        addObservers(level, sinkType, filePath, loggerObservable);
        if (!timeFormat.isEmpty()) {
            LoggerConfig.timeFormat = timeFormat;
        }
    }

    static void addObservers(LogLevel level, String sinkType, String filePath, LoggerObservable loggerObservable) {
        SinkType sinkEnum;
        try {
            sinkEnum = SinkType.valueOf(sinkType);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid sink type: " + sinkType);
        }

        SinkObserver sinkObserver = sinkEnum.createSink(filePath);
//        System.out.println("BeforeAdd +"+loggerObservable.logObservers);

        for (int curLevel = level.getLevelVal(); curLevel <= 4; curLevel++) {
            loggerObservable.addObserver(LogLevel.getLogLevel(curLevel), sinkObserver);
        }
//        System.out.println("afterAdd +"+loggerObservable.logObservers);
        for (int curLevel = level.getLevelVal() - 1; curLevel >= 0; curLevel--) {
            loggerObservable.removeObserver(LogLevel.getLogLevel(curLevel), sinkObserver);
        }
//        System.out.println("After Remove +"+loggerObservable.logObservers);

    }

}
