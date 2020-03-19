package json.processing.util.modelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanRegister {

    @Bean
    public ModelMapper getMapper() {
        return new ModelMapper();
    }
}
