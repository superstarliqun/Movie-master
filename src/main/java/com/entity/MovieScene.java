package com.entity;

import java.util.Date;

public class MovieScene {
    private Integer id;

    /**
    * 电影与场次的关联id
    */
    private Integer cinemaMovieMiddleId;

    /**
    * 放映时间
    */
    private String projectionTime;

    /**
    * 放映厅
    */
    private String projectionHall;

    /**
    * 金额
    */
    private Double money;

    /**
    * 创建时间
    */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCinemaMovieMiddleId() {
        return cinemaMovieMiddleId;
    }

    public void setCinemaMovieMiddleId(Integer cinemaMovieMiddleId) {
        this.cinemaMovieMiddleId = cinemaMovieMiddleId;
    }

    public String getProjectionTime() {
        return projectionTime;
    }

    public void setProjectionTime(String projectionTime) {
        this.projectionTime = projectionTime;
    }

    public String getProjectionHall() {
        return projectionHall;
    }

    public void setProjectionHall(String projectionHall) {
        this.projectionHall = projectionHall;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}