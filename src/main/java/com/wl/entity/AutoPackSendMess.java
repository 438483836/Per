package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 自动集包发送信息PLC
 * Created by Vincent on 2018-07-19.
 */
@Entity
@Table(name = "t_autoPackSendMess")
public class AutoPackSendMess implements Serializable{

    private static final long serialVersionUID = -4923301879657476294L;

    private Integer id;
    /**
     * 数据包
     */
    private String dataPacket;
    /**
     * 数据包总长度
     */
    private String packSize;
    /**
     * 上位机编号
     */
    private String pcNum;
    /**
     * 建包一段
     */
    private String builtPack1;
    /**
     * 建包二段
     */
    private String builtPack2;
    /**
     * 建包三段
     */
    private String builtPack3;
    /**
     * 备用
     */
    private String backup;
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

    public String getDataPacket() {
        return dataPacket;
    }

    public void setDataPacket(String dataPacket) {
        this.dataPacket = dataPacket;
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

    public String getBuiltPack1() {
        return builtPack1;
    }

    public void setBuiltPack1(String builtPack1) {
        this.builtPack1 = builtPack1;
    }

    public String getBuiltPack2() {
        return builtPack2;
    }

    public void setBuiltPack2(String builtPack2) {
        this.builtPack2 = builtPack2;
    }

    public String getBuiltPack3() {
        return builtPack3;
    }

    public void setBuiltPack3(String builtPack3) {
        this.builtPack3 = builtPack3;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public AutoPackSendMess() {
    }
}
