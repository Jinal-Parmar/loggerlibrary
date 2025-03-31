package org.example;


import org.example.enums.LogLevel;
import org.example.sink.SinkObserver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LoggerObservable {
    Map<LogLevel, Set<SinkObserver>> logObservers = new HashMap<>();

    public void addObserver(LogLevel level, SinkObserver sinkObserver) {
        Set<SinkObserver> currentLogger = logObservers.getOrDefault(level, new HashSet<>());
        currentLogger.add(sinkObserver);
        this.logObservers.put(level, currentLogger);
    }

    public void removeObserver(LogLevel level, SinkObserver sinkObserver) {
        Set<SinkObserver> currentLogger = logObservers.getOrDefault(level, new HashSet<>());
        currentLogger.remove(sinkObserver);
    }

    public void notifyAllObserver(LogLevel level, LogMessage message) {
        Set<SinkObserver> sinkObservers = logObservers.getOrDefault(level, new HashSet<>());
//        System.out.println(level+" :" + sinkObservers+": "+ logObservers + ": ");
        sinkObservers.forEach(observer -> observer.log(message));

    }
}