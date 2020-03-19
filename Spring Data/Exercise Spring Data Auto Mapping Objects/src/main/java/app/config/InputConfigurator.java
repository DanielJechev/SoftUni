package app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class InputConfigurator {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    @Bean
    public Scanner scanner(){
        return scanner;
    }
}
