package com.dosoar.email_security_demo.controller;


import com.anwen.mongo.model.PageParam;
import com.anwen.mongo.model.PageResult;
import com.anwen.mongo.toolkit.StringUtils;
import com.dosoar.email_security_demo.common.Result;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.model.param.AddEmailParam;
import com.dosoar.email_security_demo.service.IChatService;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private IEmailStorageService emailStorageService;
    @Autowired
    private IChatService chatService;

    @PostMapping("/add")
    public Result<Boolean> addEmail(@RequestBody AddEmailParam param) {
        return Result.ok(emailStorageService.addEmail(param));
    }

    @GetMapping("/page")
    public Result<PageResult<EmailStorage>> page(Integer pageNum,Integer pageSize) {
        if (pageNum == null || pageNum < 1) {
            pageNum = 1;
        }
        if (pageSize == null || pageSize < 1) {
            pageSize = 10;
        }
        PageParam pageParam=new PageParam(pageNum,pageSize);

        PageResult<EmailStorage> pageResult = emailStorageService.lambdaQuery()
                .orderByDesc(EmailStorage::getSendDate)
                .page(pageParam);

        return Result.ok(pageResult);
    }

    @GetMapping("/faq")
    public Result<String> faq(String id) {
        String content = chatService.faqWhyAlert(id);
        if (StringUtils.isBlank(content)) {
            return Result.failed("访问异常，请稍后重试");
        }
        return Result.ok(content, "success");
    }
}
