package com.dosoar.email_security_demo.service.impl;

import com.anwen.mongo.incrementer.id.IdWorker;
import com.anwen.mongo.service.impl.ServiceImpl;
import com.dosoar.email_security_demo.enums.EmailStorageStatusEnum;
import com.dosoar.email_security_demo.enums.EmailStorageTypeEnum;
import com.dosoar.email_security_demo.invoker.EmailClfInvoker;
import com.dosoar.email_security_demo.invoker.model.param.EmailClfParam;
import com.dosoar.email_security_demo.invoker.model.response.EmailClfResponse;
import com.dosoar.email_security_demo.model.dto.EmailDto;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.model.param.AddEmailParam;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import com.dosoar.email_security_demo.utils.EmailUtils;
import com.dosoar.email_security_demo.utils.PathUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EmailStorageServiceImpl extends ServiceImpl<EmailStorage> implements IEmailStorageService {
    @Autowired
    private EmailClfInvoker emailClfInvoker;

    @Autowired
    private PathUtils pathUtils;

    @Override
    public Boolean addEmail(AddEmailParam param) {
        String emailAbsolutePath = pathUtils.getEmailAbsolutePath(param.getFilePath());

        EmailDto emailDto;
        try {
            emailDto = EmailUtils.parseEml(emailAbsolutePath);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        String id = IdWorker.getIdStr();
        EmailStorage emailStorage = new EmailStorage();
        BeanUtils.copyProperties(emailDto, emailStorage);
        BeanUtils.copyProperties(param, emailStorage);
        emailStorage.setId(id);
        emailStorage.setStatus(EmailStorageStatusEnum.CHECKING.getCode());

//        CompletableFuture.runAsync(() -> {
//            EmailClfParam emailClfParam = new EmailClfParam();
//            emailClfParam.setModel_type("model_1");
//            List<String> email_path=new ArrayList<>();
//            email_path.add(emailAbsolutePath);
//            emailClfParam.setEmail_path(email_path);
//
//            EmailClfResponse response = emailClfInvoker.emailClf(emailClfParam);
//
//            EmailStorage es = new EmailStorage();
//            es.setId(id);
//            if (response != null) {
//                es.setType(response.getLabel().get(0));
//                es.setStatus(response.getLabel().get(0));
//            } else {
//                es.setStatus(EmailStorageStatusEnum.FAIL.getCode());
//            }
//            this.updateById(es);
//        }).exceptionally(ex -> {
//            ex.printStackTrace();
//            return null;
//        });

        return this.save(emailStorage);
    }
}
