package com.dosoar.email_security_demo.enums;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public enum EmailStorageStatusEnum {
    PASSED(0, "放行"),
    INTERCEPTED(1, "拦截"),
    CHECKING(2, "检测中"),
    FAIL(3,"模型解析失败");

    private final Integer code;
    private final String desc;

    public static EmailStorageStatusEnum getEnumByCode(Integer code) {
        for (EmailStorageStatusEnum e : EmailStorageStatusEnum.values()) {
            if (e.code.equals(code)) {
                return e;
            }
        }
        return null;
    }
}