package com.cathome.service.impl;

import com.cathome.mapper.cat.CatMapper;
import com.cathome.pojo.cat.CatPojo;
import com.cathome.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class CatServiceImpl implements CatService {
    @Autowired
    private CatMapper catMapper;
    /**
     * 查询所有猫咪信息
     * @return
     */
    @Override
    public List<CatPojo> selectCat() {
        return catMapper.selectCat();
    }
}
