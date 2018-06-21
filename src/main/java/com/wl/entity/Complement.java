package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
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
    private Integer dataPacket;

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
    private Integer packageInt;

    /**
     * 包裹重量小数位
     */
    private Integer packageDec;

    /**
     * 格口号码
     */
    private Integer slogan;

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

    public Integer getPackageInt() {
        return packageInt;
    }

    public void setPackageInt(Integer packageInt) {
        this.packageInt = packageInt;
    }

    public Integer getPackageDec() {
        return packageDec;
    }

    public void setPackageDec(Integer packageDec) {
        this.packageDec = packageDec;
    }

    public Integer getSlogan() {
        return slogan;
    }

    public void setSlogan(Integer slogan) {
        this.slogan = slogan;
    }

    public String getBackup() {
        return backup;
    }

    public void setBackup(String backup) {
        this.backup = backup;
    }

    public Integer getDataPacket() {
        return dataPacket;
    }

    public void setDataPacket(Integer dataPacket) {
        this.dataPacket = dataPacket;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
     }


    public Complement(){

    }






}
