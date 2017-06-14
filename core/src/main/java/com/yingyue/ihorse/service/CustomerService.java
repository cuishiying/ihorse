package com.yingyue.ihorse.service;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.entity.AdminRole;
import com.yingyue.ihorse.repository.AdminRepository;
import com.yingyue.ihorse.repository.AdminRoleRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by cuishiying on 2017/5/10.
 */
@Service
@Transactional
public class CustomerService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private AdminRoleRepository adminRoleRepository;


    public AjaxResponse regist(Admin admin){
        admin.setPassword(BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt(4)));
        AdminRole adminRole = adminRoleRepository.findByRoleName("Customer");
        //todo   判断手机号或者帐号是否已经存在
        admin.setAdminRole(adminRole);
        try{
            adminRepository.save(admin);
        }catch (Exception e){
            return AjaxResponse.fail("您的帐号已存在");
        }
        return AjaxResponse.success("注册成功");
    }

    public Page<Admin> getCustomers(Pageable pageable){
        Page<Admin> page = adminRepository.findAll(pageable);
        return page;
    }

    public AjaxResponse login(String accountNumber, String password){
        Admin admin = StringUtils.isNotBlank(accountNumber) ? adminRepository.findByAccountNumber(accountNumber) : null;
        if (admin == null) return AjaxResponse.fail("帐号不存在");
        if (!BCrypt.checkpw(password, admin.getPassword()))
            return AjaxResponse.fail("密码错误");
        return AjaxResponse.success(admin.getId());
    }
    public AjaxResponse updatePassword(String phone, String password) {
        Admin admin = adminRepository.findByPhone(phone);
        if (admin == null) return AjaxResponse.fail("修改失败！此手机号未注册。");
        if (StringUtils.isBlank(password)) return AjaxResponse.fail("密码不能为空");
        admin.setPassword(BCrypt.hashpw(password, BCrypt.gensalt(4)));
        return AjaxResponse.success();
    }
    /**
     * 获取用户详情
     */
    public Admin findOne(Integer id) {
        return adminRepository.findOne(id);
    }

    public AjaxResponse updateAdmin(Integer id,Admin updateAdmin){
        Admin admin = adminRepository.findById(id);
        admin.getAdminRole().getAuthorities().size();
        admin.setAdminName(updateAdmin.getAdminName());
        admin.setPhone(updateAdmin.getPhone());
        admin.setIdCard(updateAdmin.getIdCard());
        admin.setQqNumber(updateAdmin.getQqNumber());
        admin.setWeixin(updateAdmin.getWeixin());
        return AjaxResponse.success("修改成功");
    }

    public AjaxResponse deleteAdmin(int id){
        adminRepository.delete(id);
        return AjaxResponse.success();
    }
}
