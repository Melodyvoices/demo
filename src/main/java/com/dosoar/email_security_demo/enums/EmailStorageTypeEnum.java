package com.dosoar.email_security_demo.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;
@Getter
@AllArgsConstructor
public enum EmailStorageTypeEnum {
    NORMAL(0, "正常邮件"),
    MALICIOUS(1, "恶意邮件");

    private final Integer code;
    private final String desc;

    public static EmailStorageTypeEnum getEnumByCode(Integer code) {
        for (EmailStorageTypeEnum e : EmailStorageTypeEnum.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}