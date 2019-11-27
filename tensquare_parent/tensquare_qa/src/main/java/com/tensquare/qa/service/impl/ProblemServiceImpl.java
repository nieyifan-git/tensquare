package com.tensquare.qa.service.impl;

import com.tensquare.qa.dao.ProblemRepository;
import com.tensquare.qa.po.Problem;
import com.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author nieyifan
 * @createTime 2019/11/25 11:34
 */
@Service
public class ProblemServiceImpl implements ProblemService {
    @Autowired
    private ProblemRepository problemRepository;
    @Override
    public Page<Problem> findNewListByLabelId(String labelId, int page, int Size) {

        return problemRepository.findNewListByLabelId(labelId, PageRequest.of(page - 1, Size));
    }
}
