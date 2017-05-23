package com.yingyue.ihorse.repository;

import com.yingyue.ihorse.entity.AdminRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by cuishiying on 2017/5/11.
 */
public interface AdminRoleRepository extends JpaRepository<AdminRole,Integer> {
    AdminRole findByRoleName(String roleName);
}
