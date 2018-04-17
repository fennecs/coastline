package com.htc.coastline.util;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;

public class OpenCVUtil {
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }

    public static void cvCanny(){
        try {
            File file = ResourceUtils.getFile("classpath:static/images/1/LC08_L1TP_123045_20131003_20170429_01_T1.jpg");

            Mat src = Imgcodecs.imread(file.getAbsolutePath(), Imgcodecs.IMREAD_GRAYSCALE);

            Mat dst = src.clone();
            Imgproc.GaussianBlur(src, dst, new Size(3, 3), 0);

            Imgproc.Canny(dst, dst, 40, 100);

            Imgcodecs.imwrite("D:\\canny1.jpg", dst);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
