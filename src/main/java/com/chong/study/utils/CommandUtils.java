package com.chong.study.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandUtils {
    public static int executeWinmerge(String winMergetPath, String file1, String file2, String targetFile)
            throws IOException, InterruptedException {

        String param1 = "/minimize";
        String param2 = "/noninteractive";
        String param3 = "/u";
        String param4 = "/or";
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command().add(winMergetPath);
        processBuilder.command().add(file1);
        processBuilder.command().add(file2);

        processBuilder.command().add(param1);
        processBuilder.command().add(param2);
        processBuilder.command().add(param3);
        processBuilder.command().add(param4);

        processBuilder.command().add(targetFile);
        Process process = processBuilder.start();
        return process.waitFor();
    }

    public static String getMd5(String filePath) throws IOException, InterruptedException {
        System.out.println("==========filePath: " + filePath + "========");
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command().add("certutil");
        processBuilder.command().add("-hashfile");
        processBuilder.command().add(filePath);
        processBuilder.command().add("MD5");

        Process process = processBuilder.start();
        process.waitFor();
        if (process.exitValue() == 0) {
            List<String> resultList = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    resultList.add(line);
                }
            }
            return resultList.get(1);
        } else {
            return "error";
        }
    }

    private CommandUtils() {

    }
}
