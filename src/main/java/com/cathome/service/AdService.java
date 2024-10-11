package com.cathome.service;

import com.cathome.pojo.ad.AdBean;
import com.cathome.pojo.ad.AdPojo;

import java.util.List;

public interface AdService {

    AdBean adList(Integer page, Integer pageSize, String adName, String brandName);

    List<AdPojo> adsByID(Integer id);

    void adsDeleteById(Integer id);

    void adsUpdate(AdPojo adPojo);

    void adsInsert(AdPojo adPojo);

    void adsDelete(List<Integer> ids);
}
