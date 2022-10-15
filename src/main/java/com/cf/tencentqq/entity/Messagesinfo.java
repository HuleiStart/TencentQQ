package com.cf.tencentqq.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Messagesinfo)实体类
 *
 * @author makejava
 * @since 2022-10-06 10:49:06
 */
public class Messagesinfo implements Serializable {
    private static final long serialVersionUID = 748647290326220477L;
    
    private Integer id;
    
    private Integer fromuserid;
    
    private Integer touserid;
    
    private String message;
    
    private Integer messagetypeid;
    
    private Integer messagestate;
    
    private Date messagedate;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFromuserid() {
        return fromuserid;
    }

    public void setFromuserid(Integer fromuserid) {
        this.fromuserid = fromuserid;
    }

    public Integer getTouserid() {
        return touserid;
    }

    public void setTouserid(Integer touserid) {
        this.touserid = touserid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getMessagetypeid() {
        return messagetypeid;
    }

    public void setMessagetypeid(Integer messagetypeid) {
        this.messagetypeid = messagetypeid;
    }

    public Integer getMessagestate() {
        return messagestate;
    }

    public void setMessagestate(Integer messagestate) {
        this.messagestate = messagestate;
    }

    public Date getMessagedate() {
        return messagedate;
    }

    public void setMessagedate(Date messagedate) {
        this.messagedate = messagedate;
    }

}

