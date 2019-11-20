package com.tensquare.base.dao;

import com.tensquare.base.po.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author nieyifan
 * @createTime 2019/11/20 15:14
 */
public interface LabelRepository extends JpaRepository<Label,String>, JpaSpecificationExecutor<Label> {
}
