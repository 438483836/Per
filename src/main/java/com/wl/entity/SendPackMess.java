package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 自动集包
 * Created by Vincent on 2018-07-15.
 */
@Entity
@Table(name = "t_sendPackMess")
public class SendPackMess implements Serializable{

    private static final long serialVersionUID = -4241796940329590643L;
    private Integer id;
    /**
     * 数据类型
     */
    private String dataType;
    /**
     * 数据包总长度
     */
    private String packSize;
    /**
     * 上位机编号
     */
    private String pcNum;
    /**
     * 建包中一段
     */
    private String buildPackOne;
    /**
     * 建包中二段
     */
    private String buildPackTwo;
    /**
     * 建包中三段
     */
    private String buildPackThree;
    /**
     * 备用
     */
    private String backUp;
    /**
     * 校验
     */
    private String checkData;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getPcNum() {
        return pcNum;
    }

    public void setPcNum(String pcNum) {
        this.pcNum = pcNum;
    }

    public String getBuildPackOne() {
        return buildPackOne;
    }

    public void setBuildPackOne(String buildPackOne) {
        this.buildPackOne = buildPackOne;
    }

    public String getBuildPackTwo() {
        return buildPackTwo;
    }

    public void setBuildPackTwo(String buildPackTwo) {
        this.buildPackTwo = buildPackTwo;
    }

    public String getBuildPackThree() {
        return buildPackThree;
    }

    public void setBuildPackThree(String buildPackThree) {
        this.buildPackThree = buildPackThree;
    }

    public String getBackUp() {
        return backUp;
    }

    public void setBackUp(String backUp) {
        this.backUp = backUp;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public SendPackMess() {
    }
}
