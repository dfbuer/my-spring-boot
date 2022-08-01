package com.buer.domain;


public class Book {
    private Integer emp_id;
    private Integer age;
    private String emp_name;
    private String sex;
    private String email;

    @Override
    public String toString() {
        return "Book{" +
                "emp_id=" + emp_id +
                ", age=" + age +
                ", emp_name='" + emp_name + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Book(Integer emp_id, Integer age, String emp_name, String sex, String email) {
        this.emp_id = emp_id;
        this.age = age;
        this.emp_name = emp_name;
        this.sex = sex;
        this.email = email;
    }

    public Book() {
    }

    public Integer getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Integer emp_id) {
        this.emp_id = emp_id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
