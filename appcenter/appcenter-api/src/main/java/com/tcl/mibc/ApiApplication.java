package com.tcl.mibc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类
 * @author linglong.he
 * @date 2019-06-12 13:58
 **/
@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class,args);
    }
}
