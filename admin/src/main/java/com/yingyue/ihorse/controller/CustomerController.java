package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by cuishiying on 2017/5/9.
 */
@RestController
@RequestMapping("/admin")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    /**
     * 首页
     * @return
     */
//    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping
    public ModelAndView index(@RequestParam(required = false) String keyword, @PageableDefault Pageable pageable){
        ModelAndView model = new ModelAndView("customer_list");
        Page<Admin> page = customerService.getCustomers(pageable);
        model.addObject("page",page);
        model.addObject("keyword", keyword);
        return model;
    }

    @RequestMapping(path="/edit/{id}", method=RequestMethod.GET)
    public ModelAndView editCustomer(@PathVariable Integer id) {
        ModelAndView model = new ModelAndView("customer_edit");
        Admin admin = customerService.findOne(id);
        model.addObject("admin", admin);
        return model;
    }
    @RequestMapping(path="/edit/{id}", method=RequestMethod.POST)
    public AjaxResponse editExam(@PathVariable Integer id, @RequestBody Admin admin) {
        try {
            AjaxResponse response = customerService.updateAdmin(id,admin);
            return response;
        } catch (Exception e) {
            return AjaxResponse.fail("修改失败");
        }
    }

}
