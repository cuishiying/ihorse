package com.yingyue.ihorse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/5/9.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    /**
     * 首页
     * @return
     */
    @RequestMapping
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("customer_list");
        return model;
    }
}
