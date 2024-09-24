package com.dosoar.email_security_demo.model.entity;

import com.anwen.mongo.annotation.ID;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class EmailStorage extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ID
    private String id;

    /**
     * 邮件名称（.eml文件的原文件名）
     */
    private String fileName;

    /**
     * 邮件文件位置
     */
    private String filePath;

    /**
     * 邮件类型，见：EmailStorageTypeEnum
     */
    private Integer type;

    /**
     * 邮件状态，见：EmailStorageStatusEnum
     */
    private Integer status;



    // 邮件内容部分

    /**
     * 邮件标题
     */
    private String title;

    /**
     * 邮件内容
     */
    private String content;

    /**
     * 接收人（英文逗号隔开）
     */
    private String receivers;

    /**
     * 发送人（英文逗号隔开）
     */
    private String senders;

    /**
     * 邮件发送日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date sendDate;

}
