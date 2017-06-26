package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.entity.Vedio;
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

    /**
     * 视频列表
     * @return
     */
    @RequestMapping
    public ModelAndView vedioListView(@RequestParam(required = false) String keyword, @PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("vedio_list");
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
        Vedio v = vidio;
        return null;
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
