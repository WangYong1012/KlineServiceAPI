package com.brave.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_trade_market_one")
public class TTradeMarketOne extends BaseEntity
{
    @Id
    private String id;
    
    @Column(name = "goodsid", nullable = false)
    private String goodsid;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "time", nullable = false)
    private Date time;

    @Column(name = "timel", nullable = false)
    private Long timel;

    @Column(name = "openprice", nullable = false)
    private BigDecimal openprice;

    @Column(name = "highprice", nullable = false)
    private BigDecimal highprice;

    @Column(name = "lowprice", nullable = false)
    private BigDecimal lowprice;

    @Column(name = "closeprice", nullable = false)
    private BigDecimal closeprice;

    @Column(name = "", nullable = false)
    private BigDecimal volume;

    @Column(name = "turnover", nullable = false)
    private BigDecimal turnover;

    @Column(name = "state", nullable = false)
    private String state;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(String goodsid) {
        this.goodsid = goodsid == null ? null : goodsid.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getTimel() {
        return timel;
    }

    public void setTimel(Long timel) {
        this.timel = timel;
    }

    public BigDecimal getOpenprice() {
        return openprice;
    }

    public void setOpenprice(BigDecimal openprice) {
        this.openprice = openprice;
    }

    public BigDecimal getHighprice() {
        return highprice;
    }

    public void setHighprice(BigDecimal highprice) {
        this.highprice = highprice;
    }

    public BigDecimal getLowprice() {
        return lowprice;
    }

    public void setLowprice(BigDecimal lowprice) {
        this.lowprice = lowprice;
    }

    public BigDecimal getCloseprice() {
        return closeprice;
    }

    public void setCloseprice(BigDecimal closeprice) {
        this.closeprice = closeprice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getTurnover() {
        return turnover;
    }

    public void setTurnover(BigDecimal turnover) {
        this.turnover = turnover;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}