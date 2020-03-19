package com.car.dealer.config;

import com.car.dealer.utils.JaxbUtilImpl;
import com.car.dealer.utils.base.FileUtil;
import com.car.dealer.utils.FileUtilImpl;
import com.car.dealer.utils.base.JaxbUtil;
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
    public JaxbUtil jaxbUtil() {
        return new JaxbUtilImpl();
    }
}
