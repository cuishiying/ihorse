package com.yingyue.ihorse.entity;


import com.yingyue.ihorse.base.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by cuishiying on 2017/5/9.
 * 角色
 */
@Entity
public class AdminRole extends BaseEntity {

    private static final long serialVersionUID = -2494503312779746702L;
    private String roleName;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
    private List<Authority> authorities;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }


}
