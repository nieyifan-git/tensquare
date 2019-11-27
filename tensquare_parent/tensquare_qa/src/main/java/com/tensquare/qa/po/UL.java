package com.tensquare.qa.po;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:49
 */
@Data
@Entity
@Table(name = "tb_ul")
public class UL implements Serializable {
    @Id
    private String uid;

    @Id
    private String lid;

}
