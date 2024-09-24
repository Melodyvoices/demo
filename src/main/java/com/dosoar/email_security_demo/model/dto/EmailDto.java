package com.dosoar.email_security_demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {
    private String tile;

    private String content;

    private String senders;

    private String recipients;

    private Date sendDate;
}
