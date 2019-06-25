package com.tcl.mibc.data.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


/**
 * 数据源配置类
 *
 * @author yann.feng
 * @create 2018-08-21 15:27
 **/
@Configuration
@EnableMongoRepositories(basePackages={"com.tcl.mibc.data.repository"})
public class MongodbConfig extends AbstractMongoConfiguration {

    @Value("${spring.data.mongodb.uri}")
    private String uri;

    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @Override
    public Mongo mongo() throws Exception {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        return new MongoClient(mongoClientURI);
    }

    @Override
    public MongoTemplate mongoTemplate()  throws Exception {

        //remove _class
        MappingMongoConverter converter = mappingMongoConverter();
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));

        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), converter);

        return mongoTemplate;

    }

    @Override
    protected String getDatabaseName() {
        return dbName;
    }
}