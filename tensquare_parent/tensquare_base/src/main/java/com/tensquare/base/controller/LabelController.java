package com.tensquare.base.controller;

import com.alibaba.fastjson.JSONObject;
import com.tensquare.base.po.Label;
import com.tensquare.base.service.LabelService;
import com.tensquare.common.entity.PageResult;
import com.tensquare.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author nieyifan
 * @createTime 2019/11/20 15:23
 */
@RestController
@RequestMapping("/label")
@CrossOrigin
public class LabelController {

    @Autowired
    private LabelService labelService;


    @PostMapping("/list")
    public Result getAllLabel(@RequestBody JSONObject queryAndOrder){
        Page<Label> labelPage = labelService.findAll(queryAndOrder);
        return Result.susccess(new PageResult<Label>(labelPage.getTotalElements(),labelPage.getContent()));
    }
    @PutMapping
    public Result updateLabel(@RequestBody Label label){
        labelService.updateLabel(label);
        return Result.susccess();
    }
    @PostMapping
    public Result addLabel(@RequestBody Label label){
        labelService.addLabel(label);
        return Result.susccess();
    }
    @DeleteMapping("/{id}")
    public Result deleteLabel(@PathVariable String id){
        labelService.deleteById(id);
        return Result.susccess();
    }
    @GetMapping("/{id}")
    public Result getLabelById(@PathVariable String id){
        return Result.susccess(labelService.findById(id));
    }
}
