package com.yingyue.ihorse.service;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Recruit;
import com.yingyue.ihorse.repository.RecruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by cuishiying on 2017/6/16.
 */
@Service
@Transactional
public class RecruitService {

    @Autowired
    private RecruitRepository recruitRepository;

    public AjaxResponse releaseMessage(Recruit recruit){
        recruit.setPublicTime(LocalDateTime.now());
        recruitRepository.save(recruit);
        return AjaxResponse.success();
    }

    public Page<Recruit> findAll(Pageable pageable){
        Page<Recruit> page = recruitRepository.findAll(pageable);
        return page;
    }
}
