package com.tensquare.recruit.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.recruit.dao.EnterpriseRepository;
import com.tensquare.recruit.po.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
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
 * @createTime 2019/11/21 15:03
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    @Autowired
    private EnterpriseRepository enterpriseRepository;
    @Override
    public Page<Enterprise> getEnterpriseList(JSONObject queryAndOrder) {
        String orderBy = queryAndOrder.getOrDefault("orderBy", "jobCount").toString();
        Integer page = queryAndOrder.getInteger("page");
        Integer size = queryAndOrder.getInteger("size");
        if(page == null)
            page = 1;
        if(size == null)
            size = 10;
        Pageable pageable = PageRequest.of(page - 1,size,new Sort(Sort.Direction.DESC,orderBy));
        enterpriseRepository.findAll(new Specification<Enterprise>() {
            @Override
            public Predicate toPredicate(Root<Enterprise> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if(!StringUtils.isEmpty("name")){
                    predicateList.add(cb.like(root.get("name").as(String.class),"%" + queryAndOrder.getString("name") + "%"));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        },pageable);
        return null;
    }

    @Override
    public List<Enterprise> getHotEnterprise(String ishot) {
        List<Enterprise> repositoryByIshot = enterpriseRepository.findByIshot(ishot);
        return repositoryByIshot;
    }
}
