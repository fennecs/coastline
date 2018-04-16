package com.htc.coastline.service;

import com.htc.coastline.entity.AreaDTO;

import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
public interface CoastlineService {
    List<AreaDTO> selectAreas();
}
