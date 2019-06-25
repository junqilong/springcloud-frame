package com.tcl.mibc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * 启动类
 * @author linglong.he
 * @date 2019-06-12 13:58
 **/
@SpringBootApplication
@EnableZipkinServer
public class ZipkiniApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkiniApplication.class,args);
    }
}
