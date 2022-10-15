package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Animalyearinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:50:09
 */
public class Animalyearinfo implements Serializable {
    private static final long serialVersionUID = -44457642880597217L;
    
    private Integer id;
    
    private String animalyear;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAnimalyear() {
        return animalyear;
    }

    public void setAnimalyear(String animalyear) {
        this.animalyear = animalyear;
    }

}

