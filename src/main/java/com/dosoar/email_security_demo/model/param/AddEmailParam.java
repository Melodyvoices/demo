package com.dosoar.email_security_demo.model.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmailParam implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String fileName;

    private String filePath;
}
