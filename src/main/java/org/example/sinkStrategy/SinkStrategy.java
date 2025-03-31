package org.example.sinkStrategy;

import org.example.sink.SinkObserver;

public interface SinkStrategy {
    SinkObserver createSink(String filePath);
}
