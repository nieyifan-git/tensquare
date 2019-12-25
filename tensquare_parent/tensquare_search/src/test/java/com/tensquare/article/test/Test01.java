package com.tensquare.article.test;

import com.tensquare.common.util.IdWorker;
import com.tensquare.search.RecuritApplication;
import com.tensquare.search.dao.ArticleSearchDao;
import com.tensquare.search.po.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author 45775
 * @Date 2019/12/25 23:17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = RecuritApplication.class)
public class Test01 {

    @Autowired
    ArticleSearchDao articleSearchDao;
    @Autowired
    IdWorker idWorker;

    @Test
    public void test01(){
        Article article = new Article();
        article.setId(idWorker.nextId()+"");
        article.setState("碎觉");
        article.setContent("二憨早点睡觉");
        article.setState("1");
        articleSearchDao.save(article);
    }
}
