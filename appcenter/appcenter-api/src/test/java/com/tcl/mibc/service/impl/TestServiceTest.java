package com.tcl.mibc.service.impl;

import com.tcl.mibc.BaseTest;
import com.tcl.mibc.data.entity.MongoTest;
import com.tcl.mibc.service.ITestService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linglong.he on 2019/6/25.
 */
public class TestServiceTest extends BaseTest{

    @Autowired
    private ITestService testService;

    @Test
    public void insertMongoTest() throws Exception {
        MongoTest mongoTest = new MongoTest();
        mongoTest.setName("api source");
        testService.insertMongoTest(mongoTest);
    }

}