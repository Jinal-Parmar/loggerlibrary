package org.example.sinkStrategy;

import org.example.sink.FileSinkObserver;
import org.example.sink.SinkObserver;

public class FileSinkStrategy implements SinkStrategy {
    @Override
    public SinkObserver createSink(String filePath) {
        return FileSinkObserver.getFileSinkInstance(filePath);
    }
}
