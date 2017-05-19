package com.vivekganesan.cddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by Vivek on 18-05-2017.
 */

@SpringBootApplication
public class TaskListApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(TaskListApplication.class, args);
    }
}
