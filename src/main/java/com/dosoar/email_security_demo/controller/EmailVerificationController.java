package com.dosoar.email_security_demo.controller;

import com.dosoar.email_security_demo.common.Result;
import com.dosoar.email_security_demo.model.param.AddEmailParam;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailVerificationController {
    @Autowired
    private IEmailStorageService emailStorageService;

    @PostMapping("/add")
    public Result<Boolean> addEmail(@RequestBody AddEmailParam param) {
        return Result.ok(emailStorageService.addEmail(param));
    }
}
