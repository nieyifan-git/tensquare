package com.tensquare.recruit.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.recruit.contant.Contants;
import com.tensquare.recruit.dao.RecruitRepositroy;
import com.tensquare.recruit.po.Recruit;
import com.tensquare.recruit.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 12:38
 */
@Service
public class RecruitServiceImpl implements RecruitService {
    @Autowired
    RecruitRepositroy recruitRepositroy;
    @Override
    public Page<Recruit> getRecruitList(JSONObject queryAndOder) {
        Integer page = queryAndOder.getInteger("page");
        Integer size = queryAndOder.getInteger("size");
        if(page == null){
            page = 1;
        }
        if(size == null){
            size = 10;
        }
        String oderBy = queryAndOder.getString("oderBy");
        if(oderBy == null){
            oderBy = "createTime";
        }
        Pageable pageable = PageRequest.of(page - 1,size,new Sort(Sort.Direction.DESC,oderBy));
        Page<Recruit> recruitPage = recruitRepositroy.findAll(new Specification<Recruit>() {
            @Override
            public Predicate toPredicate(Root<Recruit> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if (!StringUtils.isEmpty("jobName")) {
                    predicateList.add(cb.like(root.get("jobName").as(String.class), "%" + queryAndOder.getString("jobName") + "%"));
                }
                if (!StringUtils.isEmpty("salary")) {
                    predicateList.add(cb.equal(root.get("salary").as(String.class), queryAndOder.getString("salary")));
                }

                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        }, pageable);


        return recruitPage;
    }

    @Override
    public List<Recruit> getRecommendRecruit(String state) {
        if(Contants.RECOMMEND_RECRUIT.equals(state)){
            return recruitRepositroy.findTop4ByStateOrderByCreateTimeDesc(state);
        }else if(Contants.NOT_NEW_RECRUIT.equals(state)){
            return recruitRepositroy.findTop12ByStateNotOrderByCreateTimeDesc(state);
        }
        return null;
    }
}
