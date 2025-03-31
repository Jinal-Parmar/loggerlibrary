package org.example.sinkStrategy;

import org.example.sink.ConsoleSinkObserver;
import org.example.sink.SinkObserver;

public class ConsoleSinkStrategy implements SinkStrategy {
    @Override
    public SinkObserver createSink(String filePath) {
        return ConsoleSinkObserver.getConsoleSinkInstance();
    }
}