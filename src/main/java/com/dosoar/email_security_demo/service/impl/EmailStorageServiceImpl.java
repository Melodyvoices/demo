package com.dosoar.email_security_demo.service.impl;

import com.anwen.mongo.service.impl.ServiceImpl;
import com.dosoar.email_security_demo.model.dto.EmailDto;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.model.param.AddEmailParam;
import com.dosoar.email_security_demo.service.IEmailStorageService;
import com.dosoar.email_security_demo.utils.EmailUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class EmailStorageServiceImpl extends ServiceImpl<EmailStorage> implements IEmailStorageService {
    @Override
    public Boolean addEmail(AddEmailParam param) {
        EmailDto emailDto ;
        try {
            emailDto= EmailUtils.parseEml(param.getFilePath());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        EmailStorage emailStorage = new EmailStorage();
        BeanUtils.copyProperties(emailDto, emailStorage);
        emailStorage.setEmailName(param.getFileName());

        CompletableFuture.runAsync(() -> {

        }).exceptionally(ex -> {
            ex.printStackTrace();
            return null;
        });

        return this.save(emailStorage);
    }
}
