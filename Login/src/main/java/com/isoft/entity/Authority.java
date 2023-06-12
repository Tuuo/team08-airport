package com.isoft.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "t_authority")
//权限
public class Authority  implements Serializable {
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
     * @return authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * 设置
     * @param authority
     */

    public String toString() {
        return "Authority{id = " + id + ", authority = " + authority + "}";
    }
}
