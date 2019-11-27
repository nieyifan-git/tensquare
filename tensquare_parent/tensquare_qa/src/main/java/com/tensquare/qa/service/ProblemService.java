package com.tensquare.qa.service;

import com.tensquare.qa.po.Problem;
import org.springframework.data.domain.Page;

/**
 * @author nieyifan
 * @createTime 2019/11/25 11:10
 */
public interface ProblemService {
    Page<Problem> findNewListByLabelId(String labelId, int page,int size);

}
