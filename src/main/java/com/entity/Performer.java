package com.entity;

import org.springframework.web.multipart.MultipartFile;

public class Performer {
    /**
     * id
     */
    private Integer id;

    /**
     * 电影id
     */
    private Integer movieId;

    /**
     * 演员名称
     */
    private String performerName;

    /**
     * 扮演角色
     */
    private String performerRole;

    /**
     * 电影图片地址
     */
    private String performerUrl;


    private MultipartFile file;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public String getPerformerName() {
        return performerName;
    }

    public void setPerformerName(String performerName) {
        this.performerName = performerName;
    }

    public String getPerformerRole() {
        return performerRole;
    }

    public void setPerformerRole(String performerRole) {
        this.performerRole = performerRole;
    }

    public String getPerformerUrl() {
        return performerUrl;
    }

    public void setPerformerUrl(String performerUrl) {
        this.performerUrl = performerUrl;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}