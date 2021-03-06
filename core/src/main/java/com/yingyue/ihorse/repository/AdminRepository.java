package com.yingyue.ihorse.repository;

import com.yingyue.ihorse.entity.Admin;
import com.yingyue.ihorse.entity.AdminRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer>,JpaSpecificationExecutor<Admin> {

    Admin findByAccountNumber(String accountNumber);
    Admin findByAdminName(String adminName);
    Admin findById(Integer id);
    Admin findByPhone(String phone);

    @Query("select c from Admin c where  c.adminRole = ?1")
    Page<Admin> findAllEmployee(AdminRole role, Pageable pageable);

    @Query("select c from Admin c where  c.adminName = ?1")
    Admin findByName(String name);

    @Query("select c from Admin c where  c.adminRole = ?1")
    List<Admin> findEmployee(AdminRole role);

}

