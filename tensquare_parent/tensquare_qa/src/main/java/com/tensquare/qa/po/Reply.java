package com.tensquare.qa.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.management.counter.perf.PerfInstrumentation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:41
 */
@Entity
@Table(name = "tb_reply")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reply implements Serializable {
    @Id
    private String id;
    @Column(name = "peoblem_id")
    private String problemId;
    private String content;
    @Column(name = "create_time")
    private Date createTime;
    @Column(name = "update_time")
    private Date updateTime;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "nick_name")
    private String nickName;
}
