package com.htc.coastline.service;

import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.entity.BinValueDoubleList;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
public interface CoastlineService {
    List<AreaDTO> selectAreas();

    String upload(String areaName, int resolution, int coastlineType, MultipartFile file);

    void generateBlurImg(int ksize, String imgName);

    BinValueDoubleList getCharts(String imgName);

    void generateThresholdImg(int threshold, String imgName);

    void generateEdgeImg(int threshold, String imgName);

    int getCoastlineLength(String imgName);
}
