package com.htc.coastline.controller;

import com.htc.coastline.constant.ResponseCode;
import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.entity.BinValueDoubleList;
import com.htc.coastline.entity.Response;
import com.htc.coastline.service.CoastlineService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
@RequestMapping
@RestController
@CrossOrigin
public class CoastlineController {
    @Resource
    private CoastlineService coastlineService;

    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public Response<List<AreaDTO>> selectAreas() {
        return Response.success(coastlineService.selectAreas());
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response<String> getEdgeImageByAreaId(@RequestParam String areaName,
                                                 @RequestParam int resolution,
                                                 @RequestParam int coastlineType,
                                                 @RequestParam("file") MultipartFile file) {
        String imgName = coastlineService.upload(areaName, resolution, coastlineType, file);
        return Response.success(imgName);
    }

    @RequestMapping(value = "/blur", method = RequestMethod.POST)
    public Response<String> generateBlurImg(@RequestParam int ksize, @RequestParam String imgName) {
        if (ksize % 2 == 0) {
            return Response.error(ResponseCode.EVEN_REQUEST);
        }

        coastlineService.generateBlurImg(ksize, imgName);
        return Response.success(null);
    }

    @RequestMapping(value = "/charts", method = RequestMethod.GET)
    public Response<BinValueDoubleList> getCharts(String imgName) {
        return Response.success(coastlineService.getCharts(imgName));
    }

    @RequestMapping(value = "/threshold", method = RequestMethod.POST)
    public Response<Void> generateThresholdImg(int threshold, String imgName) {
        coastlineService.generateThresholdImg(threshold, imgName);
        return Response.success(null);
    }

    @RequestMapping(value = "/edge", method = RequestMethod.POST)
    public Response<Void> generateEdgeImg(int threshold, String imgName){
        coastlineService.generateEdgeImg(threshold, imgName);
        return Response.success(null);
    }

    @RequestMapping(value = "/coastlineLength", method = RequestMethod.GET)
    public Response<Integer> getCoastlineLength(@RequestParam String imgName){
        return Response.success(coastlineService.getCoastlineLength(imgName));
    }
}
