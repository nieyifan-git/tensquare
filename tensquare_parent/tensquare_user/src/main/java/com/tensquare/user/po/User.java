package com.tensquare.user.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/26 12:04
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    private String id;
    private String roleId;
    private String userName;
    private String password;
    private int followCount;
    private int fansCount;
    private Long onLine;
    private Date regDate;
    private Date updateDate;
    private String mobile;
    private Date lastLoginDate;
}
