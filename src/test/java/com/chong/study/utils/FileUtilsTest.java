package com.chong.study.utils;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class FileUtilsTest {
    @Test
    void testCopyFile() {

    }

    @Test
    void testCopyFileList() throws IOException {
        FileUtils.copyFileList("C:\\Users\\31238\\OneDrive\\デスクトップ\\test\\", "C:\\Users\\31238\\OneDrive\\デスクトップ\\result\\",
                "C:\\Users\\31238\\OneDrive\\デスクトップ\\list.txt");
    }

    @Test
    void testEquals() {

    }

    @Test
    void testGetFiles() throws IOException {
        String filePath = "C:\\Users\\31238\\OneDrive\\デスクトップ\\list.txt";
        FileUtils.getFiles(filePath).forEach(file -> {
            System.out.println(file);
        });
    }
}
