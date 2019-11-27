package com.tensquare.article.dao;

import com.tensquare.article.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author nieyifan
 * @createTime 2019/11/25 14:30
 */
public interface ArticleRepository extends JpaRepository<Article,String>, JpaSpecificationExecutor<Article> {

}
