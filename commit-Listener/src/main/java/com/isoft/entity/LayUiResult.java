package com.isoft.entity;

import lombok.Data;

@Data
public class LayUiResult {
    private Integer code=0;
    private String msg="";
    private Long count;
    private Object data;

    public LayUiResult(Long count, Object data) {
        this.count = count;
        this.data = data;
    }
}
