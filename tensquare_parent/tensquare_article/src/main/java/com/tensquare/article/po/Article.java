package com.tensquare.article.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/11/25 14:02
 */
@Entity
@Table(name = "tb_article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    private String id;
    @Column(name = "column_id")
    private String columnId;
    @Column(name = "user_id")
    private String userId;
    private String title;
    private String content;
    private String image;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    private String ispublic;
    private String istop;
    private String vistis;
    @Column(name = "thumb_up")
    private Long thumbUp;
    private Long comment;
    private String state;
    @Column(name = "channel_id")
    private String channelId;

}
