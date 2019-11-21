package com.tensquare.recruit.dao;

import com.tensquare.recruit.po.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 12:33
 */
public interface RecruitRepositroy extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    List<Recruit> findTop4ByStateOrderByCreateTimeDesc(String state);
    List<Recruit> findTop12ByStateNotOrderByCreateTimeDesc(String state);
}
