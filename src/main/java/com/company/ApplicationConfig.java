// ApplicationConfig.java
package com.company;

import com.company.service.FileReaderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public FileReaderService fileReaderService() {
        return new FileReaderService();
    }

}
