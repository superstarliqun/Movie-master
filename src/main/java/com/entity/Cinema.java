package com.entity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

public class Cinema {
    private Integer id;

    /**
     * 电影院名称
     */
    private String cinemaName;

    /**
     * 电影院地址
     */
    private String address;

    /**
     * 地区
     */
    private String region;

    /**
     * 创建时间
     */
    private Date createTime;

    private MultipartFile file;



    /**
     * 绑定的用户id
     */
    private Integer managerUserId;


    private String cinemaImgUrl;

    private String cinemaPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getManagerUserId() {
        return managerUserId;
    }

    public void setManagerUserId(Integer managerUserId) {
        this.managerUserId = managerUserId;
    }

    public String getCinemaImgUrl() {
        return cinemaImgUrl;
    }

    public void setCinemaImgUrl(String cinemaImgUrl) {
        this.cinemaImgUrl = cinemaImgUrl;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}