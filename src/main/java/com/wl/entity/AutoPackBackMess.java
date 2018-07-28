package com.wl.entity;

import javax.persistence.*;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * 自动集包返回信息
 * Created by Vincent on 2018-07-18.
 */
@Entity
@Table(name = "t_autoPackBackMess")
public class AutoPackBackMess implements Serializable{

    private static final long serialVersionUID = -7131324935453744742L;

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
     * plc站号
     */
    private String plcNum;
    /**
     * 出口编号1
     */
    private String exportNum;
    /**
     * 条码长度1
     */
    private String barcodeLength;
    /**
     * 条码编号1
     */
    private String barcode;
    /**
     * 出口编号
     */
    private String exportNum2;
    /**
     * 条码长度2
     */
    private String barcodeLength2;
    /**
     * 条码编号2
     */
    private String barcode2;
    /**
     * 出口编号3
     */
    private String exportNum3;
    /**
     * 条码长度3
     */
    private String barcodeLength3;
    /**
     * 条码编号3
     */
    private String barcode3;




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

    public String getPlcNum() {
        return plcNum;
    }

    public void setPlcNum(String plcNum) {
        this.plcNum = plcNum;
    }

    public String getExportNum() {
        return exportNum;
    }

    public void setExportNum(String exportNum) {
        this.exportNum = exportNum;
    }

    public String getBarcodeLength() {
        return barcodeLength;
    }

    public void setBarcodeLength(String barcodeLength) {
        this.barcodeLength = barcodeLength;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getExportNum2() {
        return exportNum2;
    }

    public void setExportNum2(String exportNum2) {
        this.exportNum2 = exportNum2;
    }

    public String getBarcodeLength2() {
        return barcodeLength2;
    }

    public void setBarcodeLength2(String barcodeLength2) {
        this.barcodeLength2 = barcodeLength2;
    }

    public String getBarcode2() {
        return barcode2;
    }

    public void setBarcode2(String barcode2) {
        this.barcode2 = barcode2;
    }

    public String getExportNum3() {
        return exportNum3;
    }

    public void setExportNum3(String exportNum3) {
        this.exportNum3 = exportNum3;
    }

    public String getBarcodeLength3() {
        return barcodeLength3;
    }

    public void setBarcodeLength3(String barcodeLength3) {
        this.barcodeLength3 = barcodeLength3;
    }

    public String getBarcode3() {
        return barcode3;
    }

    public void setBarcode3(String barcode3) {
        this.barcode3 = barcode3;
    }

    public AutoPackBackMess() {
    }
}
