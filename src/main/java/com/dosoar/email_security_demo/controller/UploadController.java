package com.dosoar.email_security_demo.controller;

import com.dosoar.email_security_demo.common.Result;
import com.dosoar.email_security_demo.utils.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/upload")
public class UploadController {
    @Value("${common.data.upload-path}")
    private String uploadPath;

    @RequestMapping("/uploadFile")
    public Result<Map<String, Object>> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        Map<String, Object> result = new HashMap<>();
        System.out.println(uploadPath);
        String name = FileUtil.uploadFile(file, uploadPath);
        result.put("path", name);
        result.put("originalName", file.getOriginalFilename());
        return Result.ok(result);
    }
}
