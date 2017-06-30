package com.yingyue.ihorse.service;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Vedio;
import com.yingyue.ihorse.repository.VedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * Created by cuishiying on 2017/6/30.
 */
@Service
@Transactional
public class VedioService {

    @Autowired
    private VedioRepository vedioRepository;

    public AjaxResponse addVedio(Vedio vedio){
        vedio.setCreateTime(LocalDateTime.now());
        vedioRepository.save(vedio);
        return AjaxResponse.success("保存成功");
    }

    public Page<Vedio> findAll(Pageable pageable){
        Page<Vedio> page = vedioRepository.findAll(pageable);
        return page;
    }
}
