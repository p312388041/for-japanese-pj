package com.chong.study.utils;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
    public Workbook loadExeclFile(String filePath) throws EncryptedDocumentException, IOException {
        Workbook workbook = WorkbookFactory.create(new File(filePath));
        return workbook;
    }
}
