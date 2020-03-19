package app.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
    private static ModelMapper mapper;

    static{
        mapper = new ModelMapper();
    }

    @Bean
    public ModelMapper modelMapper(){
        return mapper;
    }
}
