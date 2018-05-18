package com.htc.coastline.util;

import com.htc.coastline.CoastlineApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {
    private static final Logger log = LoggerFactory.getLogger(FileUtil.class);

    private static SimpleDateFormat format;

    static {
        format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    }

    public static String getFileName(){
        return format.format(new Date());
    }

    public static String getFilePath(String directory, String fileName) {
        try {
            String filePath = ResourceUtils.getFile(directory).getAbsolutePath().replace("\\", "/").concat("/").concat(fileName);
            log.info("getFilePath:{}", filePath);
            return filePath;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
