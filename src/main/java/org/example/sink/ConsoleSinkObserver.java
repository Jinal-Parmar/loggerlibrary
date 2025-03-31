package org.example.sink;

import org.example.LogMessage;

public class ConsoleSinkObserver implements SinkObserver {
    private static ConsoleSinkObserver consoleSinkObserver;

    private ConsoleSinkObserver() {
    }

    public static ConsoleSinkObserver getConsoleSinkInstance() {
        if (consoleSinkObserver == null) {
            synchronized (ConsoleSinkObserver.class) {
                if (consoleSinkObserver == null) {
                    consoleSinkObserver = new ConsoleSinkObserver();
                }
            }

        }
        return consoleSinkObserver;
    }

    @Override
    public void log(LogMessage logMessage) {
        System.out.println("CONSOLE MESSAGE : " + logMessage.toString());
    }
}