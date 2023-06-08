package com.wimbee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLineCounterRunnable implements Runnable {
    private Counter counter;
    private String filePath;
    private int lineCount = 0;

    public FileLineCounterRunnable(Counter counter, String filePath) {
        this.counter = counter;
        this.filePath = filePath;
    }

    public void run() {
        try {
            FileReader fr = new FileReader("./" + filePath);
            try (BufferedReader br = new BufferedReader(fr)) {
                while (br.readLine() != null) {
                    lineCount++;
                }
                synchronized (counter) {
                    counter.increment(lineCount);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public String getFilePath() {
        return filePath;
    }
}
