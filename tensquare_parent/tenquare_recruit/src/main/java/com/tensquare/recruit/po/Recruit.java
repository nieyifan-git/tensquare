package com.tensquare.recruit.po;

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
 * @createTime 2019/11/21 11:27
 */
@Entity
@Table(name = "tb_recruit")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recruit {
    @Id
    private String id;
    @Column(name = "job_name")
    private String jobName;
    //薪资范围
    private String salary;
    private String condition;
    private String education;
    //任职方式
    private String type;
    private String address;
    //企业ID
    private String eid;
    @Column(name = "create_time")
    private Date createTime;
    private String state;
    private String url;
}
