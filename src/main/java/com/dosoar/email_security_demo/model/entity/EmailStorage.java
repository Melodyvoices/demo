package com.dosoar.email_security_demo.model.entity;

import com.anwen.mongo.annotation.ID;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailStorage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ID
    private String id;

    private String emailName;

    private String filePath;

    private String receiver;

    private String sender;

    private Double status;

    private String title;

    private Double type;

}
