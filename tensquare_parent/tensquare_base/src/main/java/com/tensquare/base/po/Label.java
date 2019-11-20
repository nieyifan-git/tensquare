package com.tensquare.base.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author nieyifan
 * @createTime 2019/11/20 15:11
 */
@Entity
@Table(name = "tb_label")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label implements Serializable {
    @Id
    private String id;
    //标签名称
    @Column(name = "label_name")
    private String labelName;
    //状态
    private String state;
    //使用数量
    private Long count;
    //关注数
    private Long fans;
    //是否推荐
    private String recommend;

}
