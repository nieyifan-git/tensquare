package com.tensquare.base.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.base.dao.LabelRepository;
import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.common.util.IdWorker;
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
import java.util.Map;
import java.util.Optional;

/**
 * @author nieyifan
 * @createTime 2019/11/20 15:16
 */
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelRepository labelRepository;
    @Autowired
    private IdWorker idWorker;


    @Override
    public Page<Label> findAll(JSONObject queryAndOrder) {
        String  orderBy = queryAndOrder.getOrDefault("orderBy", "count").toString();
        Integer size = queryAndOrder.getInteger("size");
        Integer page = queryAndOrder.getInteger("page");
        if(size == null || size <= 0){
            size = 10;
        }
        if(page == null || page <= 0){
            page = 1;
        }

        Pageable pageable = PageRequest.of(page - 1, size,new Sort(Sort.Direction.DESC,orderBy));
        Specification<Label> specification = createSpecification(queryAndOrder);
        Page<Label> labelPage = labelRepository.findAll(specification, pageable);
        return labelPage;
    }

    @Override
    public Label findById(String id) {
        Optional<Label> labelOptional = labelRepository.findById(id);
        if(labelOptional.isPresent()){
            return labelOptional.get();
        }
        return null;
    }

    @Override
    public void addLabel(Label label) {
        label.setId(idWorker.nextId() + "");
        labelRepository.save(label);
    }

    @Override
    public void deleteById(String id) {
        labelRepository.deleteById(id);
    }

    @Override
    public void updateLabel(Label label) {
        labelRepository.save(label);
    }

    private Specification<Label> createSpecification(JSONObject queryAndOrder){
        return  new Specification<Label>() {
            @Override
            public Predicate toPredicate(Root<Label> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                List<Predicate> predicateList = new ArrayList<>();
                if(!StringUtils.isEmpty(queryAndOrder.getString("labelName"))){
                    predicateList.add(cb.like(root.get("labelName").as(String.class),"%" + queryAndOrder.getString("labelName") + "%" ));
                }
                if(!StringUtils.isEmpty(queryAndOrder.getString("state"))){
                    predicateList.add(cb.equal(root.get("state").as(String.class),queryAndOrder.getString("state")));
                }
                if(!StringUtils.isEmpty(queryAndOrder.getLong("count"))){
                    predicateList.add(cb.equal(root.get("count").as(Long.class),queryAndOrder.getLong("count")));

                }
                if(!StringUtils.isEmpty(queryAndOrder.getLong("fans"))){
                    predicateList.add(cb.equal(root.get("fans").as(Long.class),queryAndOrder.getLong("fans")));
                }
                if(!StringUtils.isEmpty(queryAndOrder.getString("recommend"))){
                    predicateList.add(cb.equal(root.get("recommend").as(String.class),queryAndOrder.getString("recommend")));
                }
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }
}
