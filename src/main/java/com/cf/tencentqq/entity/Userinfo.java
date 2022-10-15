package com.cf.tencentqq.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Userinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:45:48
 */
@Data
public class Userinfo implements Serializable {
    private static final long serialVersionUID = 594680178127426652L;
    
    private Integer id;
    
    private String loginpwd;
    
    private Integer friendshippolicyid;
    
    private String nickname;
    
    private Integer faceid;
    
    private String sex;
    
    private Integer age;
    
    private String name;
    
    private Integer bloodtypeid;
    
    private Integer starid;
    
    private Integer animalyearid;
    
    private String address;
    
    private Integer stateid;
    
    private Integer questionid;
    
    private String answer;

    /**
     * 个性签名
     * @return
     */
    private String signature;
}

