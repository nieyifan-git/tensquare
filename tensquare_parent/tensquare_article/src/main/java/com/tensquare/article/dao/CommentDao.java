package com.tensquare.article.dao;

import com.tensquare.article.po.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author nieyifan
 * @createTime 2019/12/20 15:19
 */
public interface CommentDao extends MongoRepository<Comment,String> {
}
