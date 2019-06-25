package com.tcl.mibc.service.impl;

import com.tcl.mibc.data.entity.MongoTest;
import com.tcl.mibc.data.repository.TestRepository;
import com.tcl.mibc.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author linglong.he
 * @date 2019-06-25 13:29
 **/
@Service
public class TestService implements ITestService{

    @Autowired
    private TestRepository testRepository;

    @Override
    public void insertMongoTest(MongoTest mongoTest) {
        testRepository.save(mongoTest);
    }
}
