package org.example.util;

import java.io.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.GZIPOutputStream;

public class FileWriteUtil {
    private static final long MAX_FILE_SIZE = 100 * 1024; // 1 KB example
    private static final Map<String, AtomicInteger> versionMap = new ConcurrentHashMap<>(); // Version per path

    public static void writeToFile(String filePath, String message) {
        try {
            versionMap.putIfAbsent(filePath, new AtomicInteger(0)); // Initialize version if absent
            rotateLogsIfNeeded(filePath);

            try (FileWriter writer = new FileWriter(filePath, true)) {
                writer.write(message + "\n");
            }
        } catch (IOException e) {
            System.err.println("Failed to write to file: " + e.getMessage());
        }

    }

    private static void rotateLogsIfNeeded(String filePath) throws IOException {
        File logFile = new File(filePath);
        if (logFile.length() >= MAX_FILE_SIZE) {
            compressAndRotate(filePath);
        }
    }

    private static void compressAndRotate(String filePath) throws IOException {
        AtomicInteger versionCounter = versionMap.get(filePath);
        int version = versionCounter.incrementAndGet(); // Increment version for specific path

        // Compress current log file
        compressFile(filePath, filePath + "." + version + ".gz");

        // Clear original log file
        new FileWriter(filePath, false).close();
    }

    private static void compressFile(String sourcePath, String destinationPath) {
        try (
                FileInputStream fis = new FileInputStream(sourcePath);
                FileOutputStream fos = new FileOutputStream(destinationPath);
                GZIPOutputStream gzipOS = new GZIPOutputStream(fos)
        ) {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                gzipOS.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.err.println("Failed to compress file: " + e.getMessage());
        }
    }
}
