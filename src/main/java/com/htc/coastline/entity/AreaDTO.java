package com.htc.coastline.entity;

import java.util.Date;

/**
 * Created by zack.huang on 2018/4/16
 */
public class AreaDTO {
    private String id;
    private String areaName;
    private int resolution;
    private int coastlineLength;
    private String imgName;
    private int coastlineType;
    private Date imgTime;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getCoastlineLength() {
        return coastlineLength;
    }

    public void setCoastlineLength(int coastlineLength) {
        this.coastlineLength = coastlineLength;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    public int getCoastlineType() {
        return coastlineType;
    }

    public void setCoastlineType(int coastlineType) {
        this.coastlineType = coastlineType;
    }


    public Date getImgTime() {
        return imgTime;
    }

    public void setImgTime(Date imgTime) {
        this.imgTime = imgTime;
    }
}
