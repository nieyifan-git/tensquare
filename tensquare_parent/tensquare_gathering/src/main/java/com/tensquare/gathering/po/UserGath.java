package com.tensquare.gathering.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sun.management.counter.perf.PerfInstrumentation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author nieyifan
 * @createTime 2019/11/25 15:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usergath")
public class UserGath implements Serializable {
    @Id
    @Column(name = "user_id")
    private String userId;

    @Id
    @Column(name = "gath_id")
    private String gathId;

    @Column(name = "exe_time")
    private String exeTime;

}
