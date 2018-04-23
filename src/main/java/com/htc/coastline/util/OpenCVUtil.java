package com.htc.coastline.util;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Collections;

public class OpenCVUtil {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void cvCanny(){
        try {
            File file = ResourceUtils.getFile("classpath:static/images/1/20160922110329239.jpeg");

            Mat src = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_GRAYSCALE);

            Mat dst = src.clone();
//            Imgproc.GaussianBlur(src, dst, new Size(3, 3), 0);
//            Imgproc.medianBlur(src, dst, 9);
//            Imgcodecs.imwrite("D:\\median.jpg", dst);

            Mat matGrey = new Mat();
            MatOfInt histSize = new MatOfInt(256);
            MatOfFloat histRange = new MatOfFloat(0, 256);
            MatOfInt channels = new MatOfInt(0);
            Imgproc.calcHist(Collections.singletonList(dst), channels, new Mat(), matGrey, histSize, histRange, false);
            for (int i = 0; i < 256; i++){
                System.out.println(String.format("bin/value[%d]:", i) + matGrey.get(i, 0)[0]);
            }

            Imgproc.threshold(dst, dst, 11478.0, 10, Imgproc.THRESH_BINARY);

            Imgproc.Canny(dst, dst, 40, 100);

            Imgcodecs.imwrite("D:\\canny.jpg", dst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        cvCanny();
    }
}
