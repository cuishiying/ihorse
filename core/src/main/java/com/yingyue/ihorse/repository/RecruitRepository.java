package com.yingyue.ihorse.repository;


import com.yingyue.ihorse.entity.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecruitRepository extends JpaRepository<Recruit, Integer>,JpaSpecificationExecutor<Recruit> {

}

