package com.chong.study.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {
    /**
     * @param sourceForlder 源文件目录
     * @param targetForlder 目标文件目录
     * @param listFilePath  待复制文件列表
     * @throws IOException
     * 
     *                     从源文件目录，复制指定文件列表中的文件到目标目录
     *                     如果有文件重复，如 a/b.txt和c/b.txt，会重命名文件为b_1.txt
     */
    public static void copyFileList(String sourceForlder, String targetForlder, String listFilePath)
            throws IOException {
        List<String> fileList = FileUtils.getFiles(listFilePath);
        try (Stream<Path> paths = Files.walk(Paths.get(sourceForlder)).filter(Files::isRegularFile)) {
            paths.forEach(path -> {
                File file = path.toFile();
                for (String fileName : fileList) {
                    if (file.getAbsolutePath().endsWith(fileName)) {
                        FileUtils.copyFile(file, targetForlder, fileName);
                    }
                }
            });
        }
    }

    /**
     * @param source         原始文件
     * @param targetForlder  目标文件目录
     * @param targetFileName 目标文件名
     * 
     *                       复制指定文件到指定目录，并指定文件名
     */
    public static void copyFile(File source, String targetForlder, String targetFileName) {
        String targetFilePath = targetForlder + "\\" + targetFileName;
        int count = 1;
        while (new File(targetFilePath).exists()) {
            String[] splits = targetFileName.split("[.]");
            String name = splits[0];
            String extention = splits[1];
            targetFilePath = targetForlder + "\\" + name + "_" + count + "." + extention;
            count++;
        }
        try {
            System.out.println("---------------source----------" + source.getAbsolutePath());
            System.out.println("---------------target----------" + targetFilePath);
            OutputStream out = new FileOutputStream(targetFilePath);
            Files.copy(Paths.get(source.getAbsolutePath()), out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param file1 文件1
     * @param file2 文件2
     * @return boolean true表示file1和file2的md5值相等
     * @throws IOException
     * 
     *                              判断两个文件的md5值是否相等
     * @throws InterruptedException
     */
    public static boolean equals(String file1, String file2) throws IOException, InterruptedException {
        String md51 = CommandUtils.getMd5(file1);
        String md52 = CommandUtils.getMd5(file2);
        return md51.equals(md52);
    }

    /**
     * @param filePath 指定文件的路径
     *                 内容为一般为：
     *                 aaa.txt
     *                 bbb.txt
     *                 ccc.exe
     * @return List<String> 文件内容
     * @throws IOException
     * 
     *                     以字符串列表的形式返回指定文件的内容
     */
    public static List<String> getFiles(String filePath) throws IOException {
        List<String> results = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(filePath))) {
            String line = in.readLine();
            while (line != null) {
                results.add(line);
                line = in.readLine();
            }
        }
        return results;
    }

    private FileUtils() {

    }
}
