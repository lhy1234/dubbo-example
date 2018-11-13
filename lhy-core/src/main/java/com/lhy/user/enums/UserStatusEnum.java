package com.lhy.user.enums;

/**
 * 用户状态枚举类
 */
public enum UserStatusEnum {

    INIT(0,"初始化"),
    DEL(1,"已删除");

    private Integer value;
    private String text;

    UserStatusEnum(Integer value, String text) {
        this.value = value;
        this.text = text;
    }

    public Integer getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
