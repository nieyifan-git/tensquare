package com.tensuqare.spit.po;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nieyifan
 * @createTime 2019/12/19 17:26
 */
@Document
@Data
public class Spit implements Serializable {
    private static final long serialVersionUID = 2260698488906342639L;

    @Id
    private String _id;
    private String content;
    private Date publishtime;
    private String userid;
    private String nickname;
    private Integer visits;
    private Integer thumbup;
    private Integer share;
    private Integer comment;
    private String state;
    private String parentid;

}
