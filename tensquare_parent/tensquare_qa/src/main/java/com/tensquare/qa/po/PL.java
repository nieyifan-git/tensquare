package com.tensquare.qa.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:38
 */
@Data
@Entity
@Table(name = "tb_pl")
public class PL implements Serializable {
    @Id
    @Column(name = "problem_id")
    private String problemId;

    @Id
    @Column(name = "label_id")
    private String labelId;

}
