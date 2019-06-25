package com.tcl.mibc.cms.control;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author linglong.he
 * @date 2019-06-25 14:04
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
}
