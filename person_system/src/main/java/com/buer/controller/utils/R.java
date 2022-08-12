package com.buer.controller.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class R {

    private Boolean flag;
    private Object data;
    private String msg;

    public R(Boolean flag){
        this.flag=flag;
    }

    public R(Boolean flag, Object date){
        this.flag=flag;
        this.data=date;
    }

    public R(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public R(String msg) {
        this.flag = false;
        this.msg = msg;
    }
}
