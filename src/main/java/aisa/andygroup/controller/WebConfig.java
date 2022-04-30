package aisa.andygroup.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home2");
        registry.addViewController("/form").setViewName("form");
        registry.addViewController("/managements").setViewName("managements");
        registry.addViewController("/soChuDaoList").setViewName("soChuDaoList");
        registry.addViewController("/soNgaySinhList").setViewName("soNgaySinhList");
        registry.addViewController("/soLinhHonList").setViewName("soLinhHonList");
        registry.addViewController("/soThaiDoList").setViewName("soThaiDoList");
        registry.addViewController("/soNhanCachList").setViewName("soNhanCachList");
        registry.addViewController("/soSuMenhList").setViewName("soSuMenhList");
        registry.addViewController("/soTruongThanhList").setViewName("soTruongThanhList");
    }
}
