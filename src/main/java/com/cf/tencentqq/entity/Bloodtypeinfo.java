package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Bloodtypeinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:49:56
 */
public class Bloodtypeinfo implements Serializable {
    private static final long serialVersionUID = -14801756645607084L;
    
    private Integer id;
    
    private String bloodtype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

}

