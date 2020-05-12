package com.entity;

import java.math.BigDecimal;
import java.util.Date;

public class OrderInfo {
    /**
     * 订单id   时间戳+6位随机数
     */
    private String id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 场次id
     */
    private Integer sceneId;

    /**
     * 总金额
     */
    private BigDecimal price;

    /**
     * 座位号 数组账号
     */
    private String seatNumber;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 购买个数
     */
    private Double number;

    /**
     * 支付状态  0：未支付订单   1：已支付订单  5：超时未支付订单
     */
    private String stauts;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getNumber() {
        return number;
    }

    public void setNumber(Double number) {
        this.number = number;
    }

    public String getStauts() {
        return stauts;
    }

    public void setStauts(String stauts) {
        this.stauts = stauts;
    }
}