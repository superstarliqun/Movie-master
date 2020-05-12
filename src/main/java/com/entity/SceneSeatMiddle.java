package com.entity;

public class SceneSeatMiddle {
    private Integer id;

    /**
     * 场次id
     */
    private Integer sceneId;

    /**
     * 座位id
     */
    private String seatId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getSeatId() {
        return seatId;
    }

    public void setSeatId(String seatId) {
        this.seatId = seatId;
    }
}