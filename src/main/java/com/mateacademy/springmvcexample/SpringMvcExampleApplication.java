package com.mateacademy.springmvcexample;

import com.mateacademy.springmvcexample.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMvcExampleApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }

}
