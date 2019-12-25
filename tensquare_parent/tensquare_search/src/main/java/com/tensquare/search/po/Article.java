package com.tensquare.search.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import java.io.Serializable;

/**
 * @ClassName Article 文章实体类
 * @Description TODO
 * @Author 45775
 * @Date 2019/12/25 23:04
 * @Version 1.0
 */
@Document(indexName = "tensquare",type = "article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article implements Serializable {
    @Id
    private String id;
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String title;//文章标题
    @Field(index = true,analyzer = "ik_max_word",searchAnalyzer = "ik_max_word")
    private String content;//文章内容
    private String state;//审核状态

}
