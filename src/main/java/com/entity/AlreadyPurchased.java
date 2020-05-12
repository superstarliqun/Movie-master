package com.entity;

public class AlreadyPurchased {
    /**
     * id
     */
    private Integer id;

    /**
     * 场次与座位的关联id
     */
    private String sceneSeatMiddleId;

    /**
     * 已占座数组以逗号分隔
     */
    private String array;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSceneSeatMiddleId() {
        return sceneSeatMiddleId;
    }

    public void setSceneSeatMiddleId(String sceneSeatMiddleId) {
        this.sceneSeatMiddleId = sceneSeatMiddleId;
    }

    public String getArray() {
        return array;
    }

    public void setArray(String array) {
        this.array = array;
    }
}