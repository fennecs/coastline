package com.htc.coastline.controller;

import com.htc.coastline.constant.ResponseCode;
import com.htc.coastline.entity.AreaDTO;
import com.htc.coastline.entity.AreaQTO;
import com.htc.coastline.entity.BinValueDoubleList;
import com.htc.coastline.entity.Response;
import com.htc.coastline.service.CoastlineService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by zack.huang on 2018/4/16
 */
@RestController
@CrossOrigin
public class CoastlineController {
    @Resource
    private CoastlineService coastlineService;

    @RequestMapping(value = "/areas", method = RequestMethod.GET)
    public Response<List<AreaDTO>> selectAreas(@RequestParam(required = false) String areaName,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeBegin,
                                               @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date timeEnd) {
        AreaQTO areaQTO = new AreaQTO();
        areaQTO.setAreaName("".equals(areaName) ? null : areaName);
        areaQTO.setTimeBegin(timeBegin);
        areaQTO.setTimeEnd(timeEnd);
        return Response.success(coastlineService.selectAreas(areaQTO));
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Response<String> getEdgeImageByAreaId(@RequestParam String areaName,
                                                 @RequestParam int resolution,
                                                 @RequestParam int coastlineType,
                                                 @RequestParam("file") MultipartFile file,
                                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date imgTime) {
        String imgName = coastlineService.upload(areaName, resolution, coastlineType, file, imgTime);
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
    public Response<Void> generateEdgeImg(@RequestParam int threshold,
                                          @RequestParam String imgName,
                                          @RequestParam int cannyThreshold) {
        coastlineService.generateEdgeImg(cannyThreshold, threshold, imgName);
        return Response.success(null);
    }

    @RequestMapping(value = "/coastlineLength", method = RequestMethod.GET)
    public Response<Integer> getCoastlineLength(@RequestParam String imgName, @RequestParam int threshold, @RequestParam int cannyThreshold) {
        return Response.success(coastlineService.getCoastlineLength(cannyThreshold, threshold, imgName));
    }

    @RequestMapping(value = "/delete/{areaId}", method = RequestMethod.POST)
    public Response<Integer> deleteAreaById(@PathVariable Long areaId){
        return Response.success(coastlineService.deleteAreaById(areaId));
    }
}
