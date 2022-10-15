package com.cf.tencentqq.entity;

import java.io.Serializable;

/**
 * (Friendsinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:49:27
 */
public class Friendsinfo implements Serializable {
    private static final long serialVersionUID = 696668451038994304L;
    
    private Integer id;
    
    private Integer hostid;
    
    private Integer friendid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    public Integer getFriendid() {
        return friendid;
    }

    public void setFriendid(Integer friendid) {
        this.friendid = friendid;
    }

}

