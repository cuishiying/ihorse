package com.yingyue.ihorse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/6/25.
 */
@RestController
@RequestMapping("/vedio")
public class VedioController {

    @RequestMapping
    public ModelAndView vedioListView(){
        ModelAndView model = new ModelAndView("vedio_list");
        return model;
    }
}
