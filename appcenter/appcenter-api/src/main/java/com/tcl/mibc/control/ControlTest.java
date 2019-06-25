package com.tcl.mibc.control;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试
 *
 * @author linglong.he
 * @date 2019-06-12 14:12
 **/
@RestController
public class ControlTest {

    private final Logger logger = LoggerFactory.getLogger(ControlTest.class);

    @ApiOperation(value = "swagger2测试action",notes = "swagger2 tt")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "受欢迎者名称",paramType = "query",required = true, dataType = "String")
            })
    @GetMapping("/sayHello")
    public String hello(@RequestParam("name") String name){
        return name +",hello";
    }

    @GetMapping("/timeout5")
    public String timeout5(){
        logger.info("{} 开始执行。。。","timeout5");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("{} 执行结束。。。","timeout5");
        return "hello5";
    }

    @GetMapping("/timeout7")
    public String timeout7(){
        logger.info("{} 开始执行。。。","timeout7");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("{} 执行结束。。。","timeout7");
        return "hello7";
    }
}
