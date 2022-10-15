package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Messagetypeinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:48:45
 */
public class Messagetypeinfo implements Serializable {
    private static final long serialVersionUID = 943296490592732786L;
    
    private Integer id;
    
    private String messagetype;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessagetype() {
        return messagetype;
    }

    public void setMessagetype(String messagetype) {
        this.messagetype = messagetype;
    }

}

