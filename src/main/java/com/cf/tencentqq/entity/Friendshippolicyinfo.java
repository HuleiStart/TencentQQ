package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Friendshippolicyinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:49:44
 */
public class Friendshippolicyinfo implements Serializable {
    private static final long serialVersionUID = -44999449167061131L;
    
    private Integer id;
    
    private String friendshippolicy;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFriendshippolicy() {
        return friendshippolicy;
    }

    public void setFriendshippolicy(String friendshippolicy) {
        this.friendshippolicy = friendshippolicy;
    }

}

