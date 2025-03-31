package org.example.sink;

import org.example.LogMessage;

public interface SinkObserver {
    void log(LogMessage message);
}