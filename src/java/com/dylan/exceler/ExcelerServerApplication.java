package com.dylan.exceler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author: chenyj
 * @Description:
 * @Date: Create in 2017-10-25 10:50
 */

@SpringBootApplication
public class ExcelerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExcelerServerApplication.class, args);
    }
}
