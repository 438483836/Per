package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 自动补码
 * Created by Vincent on 2018-06-19.
 */
@Entity
@Table(name = "t_complement")
public class Complement implements Serializable{

    private static final long serialVersionUID = -1510078520819173225L;

    private Integer id;

    /**
     * 数据包
     */
    private String dataPacket;

    /**
     * 数据包总长度
     */
    private String packetSize;

    /**
     * plc站口
     */
    private String plcCode;

    /**
     * 条码
     */
    private String barCode;

    /**
     * 包裹重量整数位
     */
    private String packageInt;

    /**
     * 包裹重量小数位
     */
    private String packageDec;

    /**
     * 格口号码
     */
    private String slogan;

    /**
     * 备用
     */
    private String backup;

    /**
     * 校验
     */
    private String checkData;

    /**
     * 状态
     */
    private String status;


    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(String packetSize) {
        this.packetSize = packetSize;
    }

    public String getPlcCode() {
        return plcCode;
    }

    public void setPlcCode(String plcCode) {
        this.plcCode = plcCode;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getPackageInt() {
        return packageInt;
    }

    public void setPackageInt(String packageInt) {
        this.packageInt = packageInt;
    }

    public String getPackageDec() {
        return packageDec;
    }

    public void setPackageDec(String packageDec) {
        this.packageDec = packageDec;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public String getDataPacket() {
        return dataPacket;
    }

    public void setDataPacket(String dataPacket) {
        this.dataPacket = dataPacket;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
     }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Complement(){

    }






}
