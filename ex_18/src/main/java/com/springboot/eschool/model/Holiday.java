package com.springboot.eschool.model;

import jakarta.persistence.*;
import lombok.Data;

import java.lang.reflect.Type;
@Data
@Entity
@Table(name = "holidays")
public class Holiday extends BaseEntity {

    @Id
    private String day;
    private String reason;

    @Enumerated(EnumType.STRING)
    private Type type;

    public enum Type{
        FESTIVAL, FEDERAL
    }


}
