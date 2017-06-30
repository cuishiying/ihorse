package com.yingyue.ihorse.service;

import com.yingyue.ihorse.base.AjaxResponse;
import com.yingyue.ihorse.entity.Vedio;
import com.yingyue.ihorse.repository.VedioRepository;
import com.yingyue.ihorse.utils.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by cuishiying on 2017/6/30.
 */
@Service
@Transactional
public class VedioService {

    @Autowired
    private VedioRepository vedioRepository;

    public AjaxResponse addVedio(Vedio vedio){
        String url = vedio.getUrl();
        Map<String, String> stringStringMap = StrUtils.URLRequest(url);
        String uu = stringStringMap.get("uu");
        String vu = stringStringMap.get("vu");
        vedio.setUu(uu);
        vedio.setVu(vu);
        vedio.setCreateTime(LocalDateTime.now());
        vedioRepository.save(vedio);
        return AjaxResponse.success("保存成功");
    }

    public Page<Vedio> findAll(Pageable pageable){
        Page<Vedio> page = vedioRepository.findAll(pageable);
        return page;
    }
}
