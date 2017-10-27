package com.brave.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/7 0007.
 */
@Table(name = "sjzd")
@Entity
public class JtDataDictionary
{
    @GeneratedValue
    @Id
    private String fid;//主键，唯一标识
    
    @Column(name = "version", nullable = false)
    private int version;//版本

    @Column(name = "ZDBM", nullable = false)
    private String zdbm;//字典编码

    @Column(name = "ZDMC", nullable = false)
    private String zdmc;//字典名称

    @Column(name = "parentID", nullable = false)
    private String parentID;//字典父ID

    @Column(name = "LX", nullable = false)
    private String lx;//类型

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getZdbm() {
        return zdbm;
    }

    public void setZdbm(String zdbm) {
        this.zdbm = zdbm;
    }

    public String getZdmc() {
        return zdmc;
    }

    public void setZdmc(String zdmc) {
        this.zdmc = zdmc;
    }

    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }

    public String getLx() {
        return lx;
    }

    public void setLx(String lx) {
        this.lx = lx;
    }
}