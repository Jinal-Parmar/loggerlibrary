package org.example.sink;

import org.example.LogMessage;
import org.example.util.FileWriteUtil;

public class FileSinkObserver implements SinkObserver {

    private String filePath;
    private static FileSinkObserver fileSinkObserver;

    private FileSinkObserver(String filePath) {
        this.filePath = filePath;
    }

    public static FileSinkObserver getFileSinkInstance(String filePath) {
        if (fileSinkObserver == null) {
            synchronized (FileSinkObserver.class) {
                if (fileSinkObserver == null) {
                    fileSinkObserver = new FileSinkObserver(filePath);
                }
            }

        }
        return fileSinkObserver;
    }

    @Override
    public void log(LogMessage logMessage) {
//        System.out.println("Writing to File " + logMessage.getMessage());
        FileWriteUtil.writeToFile(filePath, logMessage.toString());
    }
}