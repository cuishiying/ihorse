package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.entity.Vedio;
import com.yingyue.ihorse.service.VedioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.data.web.PageableDefault;



/**
 * Created by cuishiying on 2017/6/25.
 */
@RestController
@RequestMapping("/vedio")
public class VedioController {

    @Autowired
    private VedioService vedioService;

    /**
     * 视频列表
     * @return
     */
    @RequestMapping
    public ModelAndView vedioListView(@RequestParam(required = false) String keyword, @PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("vedio_list");
        Page<Vedio> page = vedioService.findAll(pageable);
        model.addObject("page",page);
        return model;
    }

    /**
     * 视频上传
     * @return
     */
    @RequestMapping(path = "/add",method = RequestMethod.GET)
    public ModelAndView addVedioView(){
        ModelAndView model = new ModelAndView("vedio_add");
        return model;
    }

    /**
     * 视频上传
     * @return
     */
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public AjaxResponse addVedio(@RequestBody Vedio vidio){
        AjaxResponse ajaxResponse = vedioService.addVedio(vidio);
        return ajaxResponse;
    }

    /**
     * 视频编辑
     * @return
     */
    @RequestMapping(path = "/update",method = RequestMethod.GET)
    public ModelAndView updateVedioView(){
        ModelAndView model = new ModelAndView("vedio_update");
        return model;
    }

    /**
     * 视频编辑
     * @return
     */
    @RequestMapping(path = "/update",method = RequestMethod.POST)
    public AjaxResponse updateVedio(@RequestBody Vedio vedio){
        return null;
    }

    /**
     * 删除视频
     * @return
     */
    @RequestMapping(path = "/delete/{id}",method = RequestMethod.POST)
    public AjaxResponse deleteVedio(@PathVariable Integer id){
        return null;
    }


}
