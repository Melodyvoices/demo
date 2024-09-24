package com.dosoar.email_security_demo.utils;

import com.anwen.mongo.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PathUtils {
    @Value("${common.data.upload-path}")
    private String uploadPath;

    public static String splicePath(String path1, String path2) {
        if (StringUtils.isBlank(path1)) {
            return path2;
        }

        char lastChar = path1.charAt(path1.length() - 1);
        if (lastChar == '/' || lastChar == '\\') {
            return path1 + path2;
        }
        return path1 + "/" + path2;
    }

    public String getEmailAbsolutePath(String filePath) {
        return splicePath(this.uploadPath, filePath);
    }
}
