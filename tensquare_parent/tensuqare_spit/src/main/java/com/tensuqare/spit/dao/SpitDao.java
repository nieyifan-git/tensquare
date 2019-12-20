package com.tensuqare.spit.dao;

import com.tensuqare.spit.po.Spit;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nieyifan
 * @createTime 2019/12/20 11:03
 */
public interface SpitDao extends MongoRepository<Spit,String> {
}
