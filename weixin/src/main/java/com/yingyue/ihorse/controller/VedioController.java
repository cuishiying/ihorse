package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.entity.Vedio;
import com.yingyue.ihorse.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by cuishiying on 2017/6/25.
 */
@RestController
@RequestMapping("/vedio")
public class VedioController {

    @Autowired
    private VedioService vedioService;

    @RequestMapping
    public ModelAndView vedioListView(@PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("vedio_list");
        Page<Vedio> page = vedioService.findAll(pageable);
        model.addObject("page",page);
        return model;
    }

    @RequestMapping(path = "/detail/{id}",method = RequestMethod.GET)
    public ModelAndView vedioDetail(@PathVariable Integer id){
        ModelAndView model = new ModelAndView("vedio_detail");
        Vedio vedio = vedioService.findById(id);
        model.addObject("vedio",vedio);
        return model;
    }
}
