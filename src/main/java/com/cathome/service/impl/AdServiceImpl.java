package com.cathome.service.impl;

import com.cathome.mapper.ad.AdMapper;
import com.cathome.pojo.ad.AdBean;
import com.cathome.pojo.ad.AdPojo;
import com.cathome.service.AdService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 广告数据逻辑处理
 */
@Service
public class AdServiceImpl implements AdService {
    @Autowired
    private AdMapper adMapper;

    /**
     * 分页查询所有猫咪信息
     * @param page
     * @param pageSize
     * @param adName
     * @param brandName
     * @return
     */
    @Override
    public AdBean adList(Integer page, Integer pageSize, String adName, String brandName) {
        PageHelper.startPage(page, pageSize);
        List<AdPojo> adPojoList = adMapper.adList(adName, brandName);
        Page<AdPojo> adPojoPage = (Page<AdPojo>) adPojoList;

        AdBean adBean = new AdBean(adPojoPage.getTotal(), adPojoPage.getResult());
        return adBean;
    }

    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    @Override
    public List<AdPojo> adsByID(Integer id) {
        return adMapper.adsById(id);
    }

    /**
     * 根据id删除猫咪逻辑
     * @param id
     */
    @Override
    public void adsDeleteById(Integer id) {
        adMapper.adsDeleteById(id);
    }

    /**
     * 更新广告逻辑处理
     * @param adPojo
     */
    @Override
    public void adsUpdate(AdPojo adPojo) {
        adMapper.adsUpdate(adPojo);
    }

    /**
     * 新增广告逻辑处理
     * @param adPojo
     */
    @Override
    public void adsInsert(AdPojo adPojo) {
        adMapper.adsInsert(adPojo);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void adsDelete(List<Integer> ids) {
        adMapper.adsDelete(ids);
    }
}
