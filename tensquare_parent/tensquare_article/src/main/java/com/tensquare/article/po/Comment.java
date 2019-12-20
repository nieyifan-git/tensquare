package com.tensquare.article.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/20 15:16
 * 文章评论（mongodb）
 */
@Document
@Data
public class Comment implements Serializable {
    private static final long serialVersionUID = -2574356270006175043L;

    @Id
    private String _id;
    private String articleid;
    private String content;
    private String userid;
    private String parentid;
    private Date publishdate;

}
