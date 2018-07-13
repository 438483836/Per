package com.wl.entity;

import java.io.Serializable;

/**
 * Created by Vincent on 2018-07-04.
 */
public class ZtoResponseTO implements Serializable{

    private static final long serialVersionUID = 7590383730773235362L;

    /**
     * 状态
     */
    private String status;
    /**
     * 状态信息,成功或其它
     * 成功：SUCCESS
     */
    private String statusCode;
    /**
     * 集包号
     */
    private String packageCode;
    /**
     * 分拣模式
     */
    private String sortMode;
    /**
     * 目的站点编码
     */
    private String destSiteCode;
    /**
     * 目的站点名
     */
    private String destSiteName;
    /**
     * 备注信息
     */
    private String remark;

    public ZtoResponseTO() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getPackageCode() {
        return packageCode;
    }

    public void setPackageCode(String packageCode) {
        this.packageCode = packageCode;
    }

    public String getSortMode() {
        return sortMode;
    }

    public void setSortMode(String sortMode) {
        this.sortMode = sortMode;
    }

    public String getDestSiteCode() {
        return destSiteCode;
    }

    public void setDestSiteCode(String destSiteCode) {
        this.destSiteCode = destSiteCode;
    }

    public String getDestSiteName() {
        return destSiteName;
    }

    public void setDestSiteName(String destSiteName) {
        this.destSiteName = destSiteName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "ZtoResponseTO{" +
                "status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", packageCode='" + packageCode + '\'' +
                ", sortMode='" + sortMode + '\'' +
                ", destSiteCode='" + destSiteCode + '\'' +
                ", destSiteName='" + destSiteName + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
