package com.tensquare.qa.dao;

import com.tensquare.qa.po.Problem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

/**
 * @author nieyifan
 * @createTime 2019/11/25 11:03
 */
public interface ProblemRepository extends JpaRepository<Problem, String>, JpaSpecificationExecutor<Problem> {
    /*
    * 根据标签id查询最新问题列表
    * */

    @Query("select p from Problem p where id in (select problemId from PL WHERE labelId = ?1) order by replyTime desc ")
    Page<Problem> findNewListByLabelId(String labelId, Pageable pageable);
}
