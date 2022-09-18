package com.my.xxtbackgroud.utils;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Result {
    private Boolean flag;
    private Object data;
    private String msg;

    public Result(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(Boolean flag) {
        this.flag = flag;
    }

    public Result(Boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(String msg) {
        this(false,msg);
    }
}
