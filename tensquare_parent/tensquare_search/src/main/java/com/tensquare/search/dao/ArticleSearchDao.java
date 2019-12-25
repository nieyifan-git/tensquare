package com.tensquare.search.dao;

import com.tensquare.search.po.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ClassName ArticleSearchDao
 * @Description TODO
 * @Author 45775
 * @Date 2019/12/25 23:14
 * @Version 1.0
 */
public interface ArticleSearchDao extends ElasticsearchRepository<Article,String> {
}
