package com.tcl.mibc.data.repository;

import com.tcl.mibc.data.BaseTest;
import com.tcl.mibc.data.entity.MongoTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by linglong.he on 2019/6/25.
 */
public class TestRepositoryTest extends BaseTest{

    @Autowired
    private TestRepository testRepository;


    @Test
    public void test(){
        MongoTest mt = new MongoTest();
        mt.setName("test2");
        testRepository.save(mt);
    }
}