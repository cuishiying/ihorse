package com.yingyue.ihorse.controller;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.repository.AdminRepository;
import com.yingyue.ihorse.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cuishiying on 2017/5/10.
 */
@RestController
@RequestMapping("/customer")
public class IndexController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private AdminRepository adminRepository;

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(HttpServletRequest request) {
        request.getSession().invalidate();
        ModelAndView model = new ModelAndView("emp_login");
        return model;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public AjaxResponse login(String accountNumber, String password, HttpServletRequest request) {
        AjaxResponse ajaxResponse = customerService.login(accountNumber, password);
        if(ajaxResponse.isSuccess()){
            request.getSession().setAttribute("empId", ajaxResponse.getData());
        }
        return ajaxResponse;
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("emp_login");
        request.getSession().invalidate();
        return model;
    }

    @RequestMapping(path = "/regist", method = RequestMethod.GET)
    public ModelAndView registPage() {
        ModelAndView model = new ModelAndView("emp_regist");
        return model;
    }

    @RequestMapping(path = "/regist", method = RequestMethod.POST)
    public AjaxResponse regist(@RequestBody Admin admin, String code) {
        AjaxResponse response = customerService.regist(admin);
        return response;
    }

    @RequestMapping(path = "/sendCode", method = RequestMethod.POST)
    public AjaxResponse sendCode(String phone) {

        return AjaxResponse.success("验证码发送成功！");
    }

    @RequestMapping(value = "/checkCode", method = RequestMethod.GET)
    public AjaxResponse validCode(String phone, String code) {

        return AjaxResponse.success();
    }
    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView model = new ModelAndView("emp_index");
        Integer empId = (Integer) request.getSession().getAttribute("empId");
        if (empId == null) {
            model.setViewName("emp_login");
        } else {
            Admin admin = adminRepository.findById(empId);
            model.addObject("admin", admin);
        }
        return model;
    }

    @RequestMapping(path = "/password", method = RequestMethod.GET)
    public ModelAndView password() {
        ModelAndView model = new ModelAndView("emp_password");
        return model;
    }

    @RequestMapping(path = "/password", method = RequestMethod.POST)
    public AjaxResponse password(String phone, String code, String password) {
        AjaxResponse checked = this.validCode(phone, code);
        if (!checked.isSuccess()) return checked;
        AjaxResponse result = customerService.updatePassword(phone, password);
        return result;
    }
}
