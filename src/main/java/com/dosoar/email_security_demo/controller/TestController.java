package com.dosoar.email_security_demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.anwen.mongo.incrementer.id.IdWorker;
import com.dosoar.email_security_demo.common.Result;
import com.dosoar.email_security_demo.invoker.EmailClfInvoker;
import com.dosoar.email_security_demo.invoker.model.response.EmailClfResponse;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class TestController {
    @Autowired
    private IEmailStorageService emailStorageService;

    @Autowired
    private EmailClfInvoker emailClfInvoker;

    @GetMapping("/test")
    public Result<String> test() {
//        String id = IdWorker.getIdStr();
//        EmailStorage emailStorage = new EmailStorage();
//        emailStorage.setId(id);
//        emailStorage.setEmailName("name.eml");
//        emailStorage.setTitle("The Title");
//        System.out.println(emailStorageService.save(emailStorage));
////        System.out.println(mongoTemplate.insert(emailStorage));
////        Set<String> set=mongoTemplate.getCollectionNames();
////        System.out.println(set);
        return Result.ok("success","test controller");
    }

//    @PostMapping("/abc")
//    public Result<EmailClfResponse> abc(@RequestBody JSONObject jsObject) {
//        return Result.ok(emailClfInvoker.emailClf(jsObject));
//    }
}
