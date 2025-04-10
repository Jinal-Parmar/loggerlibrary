package org.example;

import org.example.enums.SinkType;
import org.example.sink.ConsoleSinkObserver;
import org.example.sink.FileSinkObserver;
import org.example.sink.SinkObserver;

public class SinkFactory {

    public static SinkObserver getSink(SinkType type, String filePath) {
        switch (type) {
            case CONSOLE:
                return ConsoleSinkObserver.getConsoleSinkInstance();
            case FILE:
                return FileSinkObserver.getFileSinkInstance(filePath);
            default:
                throw new IllegalArgumentException("Unknown SinkType: " + type);
        }
    }
}