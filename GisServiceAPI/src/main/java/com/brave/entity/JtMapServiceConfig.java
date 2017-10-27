package com.brave.entity;

import javax.persistence.*;
import java.util.Date;

@Table(name = "dtfwpz")
@Entity
public class JtMapServiceConfig
{
    @GeneratedValue
    @Id
    private String fid;
    
    @Column(name = "version", nullable = false)
    private Integer version;

    @Column(name = "DTFWMC", nullable = false)
    private String dtfwmc;

    @Column(name = "DTFWPZLX", nullable = false)
    private String dtfwpzlx;

    @Column(name = "IP", nullable = false)
    private String ip;

    @Column(name = "DKH", nullable = false)
    private String dkh;

    @Column(name = "FWMC", nullable = false)
    private String fwmc;

    @Column(name = "FWLX", nullable = false)
    private String fwlx;

    @Column(name = "SFTJTCKZ", nullable = false)
    private String sftjtckz;

    @Column(name = "TCID", nullable = false)
    private String tcid;

    @Column(name = "DTDWMK", nullable = false)
    private String dtdwmk;

    @Column(name = "operatename", nullable = false)
    private String operatename;

    @Column(name = "createdate", nullable = false)
    private Date createdate;

    @Column(name = "UPDATEDATE", nullable = false)
    private Date updatedate;
    
    @Column(name = "TCXH", nullable = false)
    private Integer tcxh;

    @Column(name = "LXBS", nullable = false)
    private String lxbs;
    
    @Column(name = "XZQBS", nullable = false)
    private String xzqbs;
    
    @Column(name = "FWGNLX", nullable = false)
    private String fwgnlx;
    
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid == null ? null : fid.trim();
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getDtfwmc() {
        return dtfwmc;
    }

    public void setDtfwmc(String dtfwmc) {
        this.dtfwmc = dtfwmc == null ? null : dtfwmc.trim();
    }

    public String getDtfwpzlx() {
        return dtfwpzlx;
    }

    public void setDtfwpzlx(String dtfwpzlx) {
        this.dtfwpzlx = dtfwpzlx == null ? null : dtfwpzlx.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getDkh() {
        return dkh;
    }

    public void setDkh(String dkh) {
        this.dkh = dkh == null ? null : dkh.trim();
    }

    public String getFwmc() {
        return fwmc;
    }

    public void setFwmc(String fwmc) {
        this.fwmc = fwmc == null ? null : fwmc.trim();
    }

    public String getFwlx() {
        return fwlx;
    }

    public void setFwlx(String fwlx) {
        this.fwlx = fwlx == null ? null : fwlx.trim();
    }

    public String getSftjtckz() {
        return sftjtckz;
    }

    public void setSftjtckz(String sftjtckz) {
        this.sftjtckz = sftjtckz == null ? null : sftjtckz.trim();
    }

    public String getTcid() {
        return tcid;
    }

    public void setTcid(String tcid) {
        this.tcid = tcid == null ? null : tcid.trim();
    }

    public String getDtdwmk() {
        return dtdwmk;
    }

    public void setDtdwmk(String dtdwmk) {
        this.dtdwmk = dtdwmk == null ? null : dtdwmk.trim();
    }

    public String getOperatename() {
        return operatename;
    }

    public void setOperatename(String operatename) {
        this.operatename = operatename == null ? null : operatename.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    public Integer getTcxh() {
        return tcxh;
    }

    public void setTcxh(Integer tcxh) {
        this.tcxh = tcxh;
    }

    public String getLxbs() {
        return lxbs;
    }

    public void setLxbs(String lxbs) {
        this.lxbs = lxbs;
    }

    public String getXzqbs() {
        return xzqbs;
    }

    public void setXzqbs(String xzqbs) {
        this.xzqbs = xzqbs;
    }

    public String getFwgnlx() {
        return fwgnlx;
    }

    public void setFwgnlx(String fwgnlx) {
        this.fwgnlx = fwgnlx;
    }
}