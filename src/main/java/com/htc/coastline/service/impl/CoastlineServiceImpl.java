package com.htc.coastline.service.impl;

import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.mapper.AreaMapper;
import com.htc.coastline.service.CoastlineService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
@Service
public class CoastlineServiceImpl implements CoastlineService {
    @Resource
    private AreaMapper areaMapper;


    @Override
    public List<AreaDTO> selectAreas() {
        return areaMapper.select();
    }
}
