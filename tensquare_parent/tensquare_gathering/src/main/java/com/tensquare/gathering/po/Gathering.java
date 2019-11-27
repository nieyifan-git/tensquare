package com.tensquare.gathering.po;

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
 * @createTime 2019/11/25 14:53
 */
@Entity
@Table(name = "tb_gathering")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Gathering implements Serializable {
    @Id
    private String id;
    private String name;
    private String summary;
    private String detail;
    private String sponsor;
    private String image;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    private String address;
    @Column(name = "enroll_time")
    private Date enrollTime;
    private String state;
    private String city;

}
