package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 扫码信息发送给PLC
 * Created by Vincent on 2018-06-25.
 */
@Entity
@Table(name = "t_deskInformation")
public class DeskInformation implements Serializable {

    private static final long serialVersionUID = 1625550484597793311L;

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
     * 上位机编号
     */
    private String pcNum;

    /**
     * 条码长度
     */
    private String barcodeLength;

    /**
     *条码
     */
    private String barcode;

    /**
     * 格口号
     */
    private String slogan;

    /**
     * 重要信息
     */
    private String importantMess;

    /**
     * 校验
     */
    private String checkData;

    /**
     * 三段码
     */
    private String threeCode;

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

    public String getPcNum() {
        return pcNum;
    }

    public void setPcNum(String pcNum) {
        this.pcNum = pcNum;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getImportantMess() {
        return importantMess;
    }

    public void setImportantMess(String importantMess) {
        this.importantMess = importantMess;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public String getThreeCode() {
        return threeCode;
    }

    public void setThreeCode(String threeCode) {
        this.threeCode = threeCode;
    }

    public String getBarcodeLength() {
        return barcodeLength;
    }

    public void setBarcodeLength(String barcodeLength) {
        this.barcodeLength = barcodeLength;
    }

    public DeskInformation() {

    }
}
