package com.htc.coastline;

import com.htc.coastline.util.OpenCVUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CoastlineApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(CoastlineApplicationTests.class);

    @Test
    public void testChartsFirst(){
        OpenCVUtil.generateEdgeImg(55, 55,  "2018_05_07_00_25_13.jpg");

    }

    @Test
    public void testChartsSecond(){
        OpenCVUtil.generateThresholdImg(55,  "2018_05_07_00_25_13.jpg");
    }

    @Test
    public void testChartsThird(){
        OpenCVUtil.getEdgePixelNum(55, 55,  "2018_05_07_00_25_13.jpg");
    }

    @Test
    public void contextLoads() {

    }


}
