package com.cf.tencentqq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Stateinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:48:01
 */
@Data
public class Stateinfo implements Serializable {
    private static final long serialVersionUID = 638577621762002567L;
    private Integer id;
    private String state;

}

