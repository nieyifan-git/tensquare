package com.tensquare.recruit.controller;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.recruit.po.Enterprise;
import com.tensquare.recruit.service.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nieyifan
 * @createTime 2019/11/21 14:57
 */
@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Autowired
    private EnterpriseService enterpriseService;

    @PostMapping("list")
    public Result getEnterpriseList(@RequestBody JSONObject queryAndOrder){
        Page<Enterprise> enterpriseList = enterpriseService.getEnterpriseList(queryAndOrder);
        return Result.susccess(new PageResult<Enterprise>(enterpriseList.getTotalElements(),enterpriseList.getContent()));
    }

    @GetMapping("search/hot-enterprise")
    public Result getHotEnterprise(@RequestParam(name = "ishot") String ishot){
        List<Enterprise> hotEnterprise = enterpriseService.getHotEnterprise(ishot);
        return Result.susccess(hotEnterprise);
    }


}
