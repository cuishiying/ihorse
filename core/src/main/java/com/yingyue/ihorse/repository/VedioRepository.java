package com.yingyue.ihorse.repository;

import com.yingyue.ihorse.entity.Vedio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by cuishiying on 2017/6/30.
 */
public interface VedioRepository extends JpaRepository<Vedio,Integer>,JpaSpecificationExecutor<Vedio>{
}
