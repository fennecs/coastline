package com.htc.coastline.controller;

import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.entity.Response;
import com.htc.coastline.service.CoastlineService;
import com.htc.coastline.util.OpenCVUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
@RequestMapping
@RestController
public class CoastlineController {
    @Resource
    private CoastlineService coastlineService;

    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public Response<List<AreaDTO>> selectAreas(){
        return Response.success(coastlineService.selectAreas());
    }

    @RequestMapping(value = "/edge/{areaId}", method = RequestMethod.GET)
    public Response<Integer> getEdgeImageByAreaId(@PathVariable int areaId){
        OpenCVUtil.cvCanny();
        return Response.success(areaId);
    }
}
