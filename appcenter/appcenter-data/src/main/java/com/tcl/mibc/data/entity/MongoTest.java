package com.tcl.mibc.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author linglong.he
 * @date 2019-06-25 11:15
 **/

@Document(collection = "test")
public class MongoTest {


    @Id
    private String id;


    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
