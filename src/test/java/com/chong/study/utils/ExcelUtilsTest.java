package com.chong.study.utils;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.jupiter.api.Test;

public class ExcelUtilsTest {
    @Test
    void testLoadExeclFile() throws EncryptedDocumentException, IOException {
        String filePath ="C:\\Users\\31238\\OneDrive\\デスクトップ\\test.xls";
        assertNotEquals(null, ExcelUtils.loadExeclFile(filePath));
    }
}
