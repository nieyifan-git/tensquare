package com.tensquare.qa.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:18
 */
@Entity
@Table(name = "tb_problem")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Problem implements Serializable {
    @Id
    private String id;
    private String title;
    private String text;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "nick_name")
    private String nickName;
    @Column(name = "visits")
    private Long visits;
    @Column(name = "thumb_up")
    private Long thumb_up;
    private Long reply;
    private String solve;
    @Column(name = "reply_name")
    private String replyName;
    @Column(name = "reply_time")
    private String replyTime;

}
