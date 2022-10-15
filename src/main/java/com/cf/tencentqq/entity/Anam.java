package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Anam)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:50:21
 */
public class Anam implements Serializable {
    private static final long serialVersionUID = -77604700916870949L;
    
    private Integer id;
    
    private Integer qq;
    
    private String pwd;
    
    private Integer staid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getStaid() {
        return staid;
    }

    public void setStaid(Integer staid) {
        this.staid = staid;
    }

}

