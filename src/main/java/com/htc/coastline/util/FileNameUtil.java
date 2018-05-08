package com.htc.coastline.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameUtil {
    private static SimpleDateFormat format;

    static {
        format = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
    }

    public static String getFileName(){
        return format.format(new Date());
    }

}
