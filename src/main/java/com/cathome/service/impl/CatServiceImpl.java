package com.cathome.service.impl;

import com.cathome.mapper.cat.CatMapper;
import com.cathome.pojo.cat.CatPojo;
import com.cathome.pojo.cat.PageBean;
import com.cathome.service.CatService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class CatServiceImpl implements CatService {
    @Autowired
    private CatMapper catMapper;
    /**
     * 查询所有猫咪信息
     * @return
     */
    @Override
    public PageBean selectCat(Integer page, Integer pageSize, String catName, String state) {
        //设置分页查询页数
        PageHelper.startPage(page, pageSize);
        List<CatPojo> catPojoList = catMapper.selectCat(catName, state);
        Page<CatPojo> p = (Page<CatPojo>) catPojoList;
        log.info("查询到的信息", p.getResult());
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    /**
     * 根据id查询猫咪信息
     * @param id
     * @return
     */
    @Override
    public List<CatPojo> searchById(Integer id) {
        return catMapper.selectById(id);
    }

    /**
     * 更新语句操作
     * @param catPojo
     */
    @Override
    public void updateCat(CatPojo catPojo) {
        catMapper.updateCat(catPojo);
    }

    /**
     * 根据id删除猫咪
     * @param id
     */
    public void deleteCat(Integer id){
        catMapper.deleteCat(id);
    }

    /**
     * 新增猫咪
     * @param catPojo
     */
    @Override
    public void insertCat(CatPojo catPojo) {
        catMapper.insertCat(catPojo);
    }
}
