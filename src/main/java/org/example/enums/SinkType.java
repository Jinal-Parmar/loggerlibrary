package org.example.enums;

import org.example.sink.SinkObserver;
import org.example.sinkStrategy.ConsoleSinkStrategy;
import org.example.sinkStrategy.FileSinkStrategy;
import org.example.sinkStrategy.SinkStrategy;

public enum SinkType {
    CONSOLE(new ConsoleSinkStrategy()),
    FILE(new FileSinkStrategy());

    private final SinkStrategy strategy;

    SinkType(SinkStrategy strategy) {
        this.strategy = strategy;
    }

    public SinkObserver createSink(String filePath) {
        return strategy.createSink(filePath);
    }
}
