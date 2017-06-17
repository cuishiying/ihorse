package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.entity.Recruit;
import com.yingyue.ihorse.service.CustomerService;
import com.yingyue.ihorse.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/6/13.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private CustomerService customerService;
    @Autowired
    private RecruitService recruitService;

    /**
     * 信息发布
     * @return
     */
    @RequestMapping(path = "/releaseMessage",method = RequestMethod.GET)
    public ModelAndView releaseMessageView(){
        ModelAndView model = new ModelAndView("release_message");
        return model;
    }
    /**
     * 信息发布
     * @return
     */
    @RequestMapping(path = "/releaseMessage",method = RequestMethod.POST)
    public AjaxResponse releaseMessage(@RequestBody Recruit recruit){
        AjaxResponse ajaxResponse = recruitService.releaseMessage(recruit);
        return ajaxResponse;
    }
    /**
     * 招募管理
     * @return
     */
    @RequestMapping(path = "/recruitManage",method = RequestMethod.GET)
    public ModelAndView recruitManageView(@PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("signup_manage");
        Page<Recruit> page = recruitService.findAll(pageable);
        model.addObject("page",page);
        return model;
    }
    /**
     * 报名管理
     * @return
     */
    @RequestMapping(path = "/signupManage",method = RequestMethod.GET)
    public ModelAndView signupManageView(@RequestParam(required = false) String keyword, @PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("signup_manage");
        Page<Recruit> page = recruitService.findAll(pageable);
        model.addObject("page",page);
        model.addObject("keyword", keyword);
        return model;
    }
}
