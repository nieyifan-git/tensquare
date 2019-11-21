package com.tensquare.recruit.service;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.recruit.po.Recruit;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 12:36
 */
public interface RecruitService {
    Page<Recruit> getRecruitList(JSONObject queryAndOder);

    List<Recruit> getRecommendRecruit(String state);

}
