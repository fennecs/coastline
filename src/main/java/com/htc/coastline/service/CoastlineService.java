package com.htc.coastline.service;

import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.entity.AreaQTO;
import com.htc.coastline.entity.BinValueDoubleList;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
public interface CoastlineService {
    List<AreaDTO> selectAreas(AreaQTO areaQTO);

    String upload(String areaName, int resolution, int coastlineType, MultipartFile file, Date imgTime);

    void generateBlurImg(int ksize, String imgName);

    BinValueDoubleList getCharts(String imgName);

    void generateThresholdImg(int threshold, String imgName);

    void generateEdgeImg(int cannyThreshold, int threshold, String imgName);

    int getCoastlineLength(int cannyThreshold, int threshold, String imgName);

    int deleteAreaById(Long areaId);
}
