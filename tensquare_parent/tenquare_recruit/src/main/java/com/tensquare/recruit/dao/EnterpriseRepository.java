package com.tensquare.recruit.dao;

import com.tensquare.recruit.po.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 14:59
 */
public interface EnterpriseRepository extends JpaRepository<Enterprise,String>, JpaSpecificationExecutor<Enterprise> {
    List<Enterprise> findByIshot(String ishot);
}
