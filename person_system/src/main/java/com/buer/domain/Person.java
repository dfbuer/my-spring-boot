package com.buer.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Person {
    private Integer id;
    private String name;
    private String sex;
    private String studentId;
    private String tele;
    private String specialized;
    private MultipartFile schedule;
}
