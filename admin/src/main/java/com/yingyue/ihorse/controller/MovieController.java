package com.yingyue.ihorse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/6/13.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    /**
     * 信息发布
     * @return
     */
    @RequestMapping(path = "/releaseMessage",method = RequestMethod.GET)
    public ModelAndView releaseMessageView(){
        ModelAndView model = new ModelAndView("release_message");
        return model;
    }
}
