package com.wl.entity;

import java.io.Serializable;

/**
 * ZT请求体
 * Created by Vincent on 2018-07-03.
 */
public class ZtoRequestTO implements Serializable{

    private static final long serialVersionUID = -7660432930730659876L;

    /**
     * 消息内容
     */
    private Object data;

    /**
     * md5加密data
     */
    private String data_digest;

    /**
     * 消息类型
     */
    private String msg_type;

    /**
     * 公司英文缩写
     */
    private String company_id;

    public ZtoRequestTO() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getData_digest() {
        return data_digest;
    }

    public void setData_digest(String data_digest) {
        this.data_digest = data_digest;
    }

    public String getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(String msg_type) {
        this.msg_type = msg_type;
    }

    public String getCompany_id() {
        return company_id;
    }

    public void setCompany_id(String company_id) {
        this.company_id = company_id;
    }
}
