package com.htc.coastline.config;

import com.htc.coastline.constant.Directory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 映射处理图片，前端"pathPatterns"已经写死
 */
@Configuration
public class ProcessImageConfiguration implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 这里file协议要么"///"要么"/", 映射位置不要加"**",否则都能正确映射
        String processImagesLocation = "file:///".concat(Directory.PROCESS_IMAGES_HOME);
        registry.addResourceHandler("/process_images/**").addResourceLocations(processImagesLocation);
    }
}
