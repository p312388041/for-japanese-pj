package com.chong.study.utils;

import java.io.IOException;

import org.junit.jupiter.api.Test;



public class CommandUtilsTest {
    @Test
    void testExecuteWinmerge() throws IOException, InterruptedException {
        String winMergeExePath = "C:\\Program Files\\WinMerge\\WinMergeU.exe";
        String file1 = "C:\\Users\\31238\\OneDrive\\デスクトップ\\test\\data1.txt";
        String file2 = "C:\\Users\\31238\\OneDrive\\デスクトップ\\test\\data2.txt";
        String targetFile = "C:\\Users\\31238\\OneDrive\\デスクトップ\\result\\result.html";
        CommandUtils.executeWinmerge(winMergeExePath, file1, file2, targetFile);
    }

    @Test
    void testGetMd5() throws IOException, InterruptedException {
        String file1 = "C:\\Users\\31238\\OneDrive\\デスクトップ\\test\\data1.txt";
        System.out.println(CommandUtils.getMd5(file1));
    }
}
