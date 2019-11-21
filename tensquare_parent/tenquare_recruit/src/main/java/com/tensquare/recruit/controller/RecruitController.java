package com.tensquare.recruit.controller;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import com.tensquare.recruit.po.Recruit;
import com.tensquare.recruit.service.RecruitService;
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
 * @createTime 2019/11/21 10:01
 */
@RestController
@RequestMapping("/recruit")
public class RecruitController {

    @Autowired
    RecruitService recruitService;


    @PostMapping("/list")
    public Result getRecruitList(@RequestBody JSONObject queryAndOder){
        Page<Recruit> recruitList = recruitService.getRecruitList(queryAndOder);
        return Result.susccess(new PageResult<Recruit>(recruitList.getTotalElements(),recruitList.getContent()));
    }

    /*
    * 查询推荐职位展示前4条
    * */

    @GetMapping("/search/recommend")
    public Result getRecommend(@RequestParam String state){
        List<Recruit> recommend = recruitService.getRecommendRecruit(state);
        return Result.susccess(recommend);
    }
}
