package com.dosoar.email_security_demo.service;

import com.anwen.mongo.service.IService;
import com.dosoar.email_security_demo.model.entity.EmailStorage;
import com.dosoar.email_security_demo.model.param.AddEmailParam;

public interface IEmailStorageService extends IService<EmailStorage> {
    Boolean addEmail(AddEmailParam param);
}
