package com.tensquare.base.service;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.base.po.Label;
import org.springframework.data.domain.Page;
/**
 * @author nieyifan
 * @createTime 2019/11/20 15:15
 */
public interface LabelService {
    Page<Label> findAll(JSONObject queryAndOrder);
    Label findById(String id);
    void addLabel(Label label);
    void deleteById(String id);
    void updateLabel(Label label);

}
