package com.entity;

import java.util.Date;

public class Footprint {
    /**
    * id
    */
    private Integer id;

    /**
    * 电影id
    */
    private String movieId;

    /**
    * 用户id
    */
    private Integer userId;

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

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}