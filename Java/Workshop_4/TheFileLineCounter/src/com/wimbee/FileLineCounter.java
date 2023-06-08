package com.wimbee;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLineCounter extends Thread {
    private Counter counter;
    private ArrayList<String> filePaths;
    private ArrayList<FileLineCounterRunnable> flcrs;

    public FileLineCounter() {
        counter = new Counter(0);
        filePaths = new ArrayList<>();
        flcrs = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            String inputFile = scanner.nextLine();
            try {
                FileInputStream fileInputStream = new FileInputStream(inputFile);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    filePaths.add("./" + line);
                    FileLineCounterRunnable fileCounterRun = new FileLineCounterRunnable(counter, line);
                    flcrs.add(fileCounterRun);
                }
            } catch (Exception e) {
                System.out.println("File not found: " + inputFile);
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        for (FileLineCounterRunnable flcrun : flcrs) {
            Thread thread = new Thread(flcrun);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (FileLineCounterRunnable flcrResult : flcrs) {
            System.out.println(flcrResult.getFilePath() + ": " + flcrResult.getLineCount() + " lines");
        }
        System.out.println("Total lines: " + counter.getCount());
    }

    public static void main(String[] args) {
        FileLineCounter fileLineCounter = new FileLineCounter();
    }
}
