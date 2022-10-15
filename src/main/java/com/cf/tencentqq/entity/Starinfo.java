package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Starinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:48:17
 */
public class Starinfo implements Serializable {
    private static final long serialVersionUID = 551942784735934196L;
    
    private Integer id;
    
    private String star;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

}

