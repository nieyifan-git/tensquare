package com.tensquare.gathering.controller;

import com.tensquare.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nieyifan
 * @createTime 2019/11/25 16:19
 */
@RestController
@RequestMapping("/gathering")
public class GatheringController {

    @GetMapping("/test")
    public Result hello(){
        return Result.susccess("hello world");
    }
}
