package com.chong.study.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CommandUtils {
    public static int executeWinmerge(String file1, String file2, String targetFolder)
            throws IOException, InterruptedException {
        String winMergeExePath = "C:/Program File (x86)/WinMerge/WinMergeU.exe";
        String resultName = "/result.html";
        String param = " /minimize /noninteractive /u /or ";
        String command = winMergeExePath + file1 + " " + file2 + param + targetFolder + resultName;
        System.out.println(command);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        return process.waitFor();
    }

    public static String getMd5(String filePath) throws IOException {
        String command = "certutil -hashfile " + filePath + " MD5";
        System.out.println("==========filePath: " + filePath + "========" + command);
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        Process process = processBuilder.start();
        List<String> resultList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                resultList.add(line);
            }
        }
        return resultList.get(1);
    }

    private CommandUtils() {

    }
}
