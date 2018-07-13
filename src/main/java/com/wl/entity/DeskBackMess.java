package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 上件台PLC返回信息给PC机
 * Created by Vincent on 2018-06-26.
 */
@Entity
@Table(name = "t_deskBackMess")
public class DeskBackMess implements Serializable{

    private static final long serialVersionUID = -6991023230779922490L;

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
     * PLC编码
     */
    private String plcNum;

    /**
     * 条码
     */
    private String barcode;

    /**
     * 包裹重量整数位
     */
    private String packageInt;

    /**
     * 包裹重量小数位
     */
    private String packageDec;

    /**
     * 控制信息
     */
    private String controlMess;

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

    public String getPacketSize() {
        return packetSize;
    }

    public void setPacketSize(String packetSize) {
        this.packetSize = packetSize;
    }

    public String getPlcNum() {
        return plcNum;
    }

    public void setPlcNum(String plcNum) {
        this.plcNum = plcNum;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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

    public String getControlMess() {
        return controlMess;
    }

    public void setControlMess(String controlMess) {
        this.controlMess = controlMess;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public DeskBackMess(){

    }
}
