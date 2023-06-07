package com.springboot.eschool.model;

import lombok.Data;

import java.lang.reflect.Type;
@Data
public class Holiday {

    private final String day;
    private final String reason;
    private final Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }

}
