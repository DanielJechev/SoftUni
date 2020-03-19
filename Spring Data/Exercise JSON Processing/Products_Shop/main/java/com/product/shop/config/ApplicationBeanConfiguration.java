package com.product.shop.config;

import com.product.shop.utils.*;
import com.product.shop.utils.base.FileUtil;
import com.product.shop.utils.base.GsonUtil;
import com.product.shop.utils.base.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
    public FileUtil fileUtil() {
        return new FileUtilImpl();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public GsonUtil gsonUtil() {
        return new GsonUtilImpl();
    }

    @Bean
    public ValidatorUtil validatorUtil() {
        return new ValidatorUtilImpl();
    }
}
