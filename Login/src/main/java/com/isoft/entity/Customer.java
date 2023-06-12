package com.isoft.entity;



import lombok.Data;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "t_customer")
@Data
public class Customer implements Serializable {
    private static final long serialVersionUID = 7898396078272083417L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private Integer valid;

    public Customer() {
    }

    public Customer(Integer id, String username, String password, Integer valid) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.valid = valid;
    }

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }


}
