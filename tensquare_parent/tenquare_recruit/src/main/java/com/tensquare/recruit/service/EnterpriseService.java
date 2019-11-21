package com.tensquare.recruit.service;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.recruit.po.Enterprise;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 15:02
 */
public interface EnterpriseService {
    Page<Enterprise> getEnterpriseList(JSONObject queryAndOrder);

    List<Enterprise> getHotEnterprise(String ishot);
}
