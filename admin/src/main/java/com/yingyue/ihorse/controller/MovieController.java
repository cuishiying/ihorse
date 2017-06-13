package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/6/13.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private CustomerService customerService;

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
     * 报名管理
     * @return
     */
    @RequestMapping(path = "/signupManage",method = RequestMethod.GET)
    public ModelAndView signupManageView(@RequestParam(required = false) String keyword, @PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("signup_manage");
        Page<Admin> page = customerService.getCustomers(pageable);
        model.addObject("page",page);
        model.addObject("keyword", keyword);
        return model;
    }
}
