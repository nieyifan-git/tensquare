package com.tensuqare.spit.service.impl;

import com.tensuqare.spit.service.SpitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * @author nieyifan
 * @createTime 2019/12/20 11:05
 */
public class SpitServiceImpl implements SpitService {

    //实现对某列的操作
    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public void updateThumbup(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("thunmbup",1);
        mongoTemplate.updateFirst(query,update,"spit");
    }
}
