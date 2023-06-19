package com.isoft.entity;



import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "t_authority")
@Data
public class Authority  implements Serializable {
    private static final long serialVersionUID = -2708487789560050023L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String authority;

    public Authority() {
    }

    public Authority(Integer id, String authority) {
        this.id = id;
        this.authority = authority;
    }

}
