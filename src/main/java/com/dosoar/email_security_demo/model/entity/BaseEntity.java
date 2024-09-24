package com.dosoar.email_security_demo.model.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private String createTime;

    private String createUser;

    private String updateTime;

    private String updateUser;
}
