package com.dosoar.email_security_demo.utils;

import cn.hutool.core.util.ZipUtil;
import com.anwen.mongo.incrementer.id.IdWorker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class FileUtil {

    public static String uploadFile(MultipartFile file, String savePath) {
        if (file.isEmpty()) {
            throw new RuntimeException("上传失败，请选择文件");
        }
        String dateStr = DateUtil.format(new Date(), "yyyyMMdd");
        if (!savePath.endsWith("/")) {
            savePath += "/";
        }
        savePath = savePath + dateStr + "/";
        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName = file.getOriginalFilename();

        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
        String storedName = IdWorker.getIdStr() + fileSuffix;

        File dest = new File(savePath + storedName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dateStr + "/" + storedName;
    }

    public static String uploadFile(MultipartFile file, String savePath, boolean useNewFileName) {
        if (file.isEmpty()) {
            throw new RuntimeException("上传失败，请选择文件");
        }
        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        if (!savePath.endsWith("/")) {
            savePath += "/";
        }
        String fileName = file.getOriginalFilename();
        String storedName = fileName;
        if (useNewFileName) {
            String fileType = fileName.substring(fileName.lastIndexOf("."));
            storedName = IdWorker.getIdStr() + fileType;
        }
        File dest = new File(savePath + storedName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return storedName;
    }

    /**
     * 将zip包解压到同目录下
     *
     * @param file
     * @return
     * @throws Exception
     */
    public static String unZip(File file) {
        String abPath = file.getAbsolutePath();
        String destFilePath = abPath.substring(0, abPath.lastIndexOf("."));
        File outFile = new File(destFilePath);
        if (!outFile.exists()) {
            outFile.mkdirs();
        }
        ZipUtil.unzip(file, outFile, Charset.forName("GBK"));
        return destFilePath;
    }

    public static String tempFileToFormal(File file, String savePath) {
        String fileMd5 = MD5Utils.getFileMd5(file);

        String destFilePath = savePath + fileMd5;

        File destFile = new File(destFilePath);
        if (destFile.exists()) {
            return fileMd5;
        }
        try {
            FileUtils.copyFile(file, destFile);
        } catch (IOException e) {
            log.warn("复制文件失败, 目标路径 " + savePath, e);
        }
        return fileMd5;
    }

    public static String readFile(String filePath) throws Exception {
        File file = new File(filePath);
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        return sb.toString();
    }

    public static void deleteFiles(List<String> filePaths) {
        for (String filePath : filePaths) {
            deleteFile(filePath);
        }
    }

    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new File("e:/aa/aa.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader br = new BufferedReader(fileReader);
        StringBuffer sb = new StringBuffer();
        String line;
        Set<String> set = new HashSet<>();
        while ((line = br.readLine()) != null) {
            set.add(line);
        }
        System.out.println(set.toString());
    }
}
