package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Questioninfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:48:32
 */
public class Questioninfo implements Serializable {
    private static final long serialVersionUID = 948762936114524962L;
    
    private Integer id;
    
    private String question;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}

