package com.isoft.vo;

import com.isoft.entity.Apot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    private Integer page;
    private Integer limit;
}
