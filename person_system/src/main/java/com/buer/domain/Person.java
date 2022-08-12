package com.buer.domain;

import lombok.Data;

@Data
public class Person {
    private Integer id;
    private String name;
    private String sex;
    private String studentId;
    private String tele;
    private String specialized;
    private byte[] schedule;
}
