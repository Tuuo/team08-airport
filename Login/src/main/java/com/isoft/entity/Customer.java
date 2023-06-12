package com.isoft.entity;



import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "t_customer")
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

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return valid
     */
    public Integer getValid() {
        return valid;
    }

    /**
     * 设置
     * @param valid
     */
    public void setValid(Integer valid) {
        this.valid = valid;
    }

    public String toString() {
        return "Customer{id = " + id + ", username = " + username + ", password = " + password + ", valid = " + valid + "}";
    }
}
