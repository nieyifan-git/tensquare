package com.tensquare.qa.controller;

import com.tensquare.common.entity.Result;
import com.tensquare.qa.po.Problem;
import com.tensquare.qa.service.ProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nieyifan
 * @createTime 2019/11/25 10:18
 */
@RestController
@RequestMapping("/peoblem")
public class ProblemController {

    @Autowired
    private ProblemService problemService;

    @GetMapping("/get-problem-label")
    public Result getProblemByLabel(@RequestParam String labelId,@RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                    @RequestParam(name = "size",defaultValue = "10",required = false) int size){
        return Result.susccess(problemService.findNewListByLabelId(labelId,page,size));

    }
}
