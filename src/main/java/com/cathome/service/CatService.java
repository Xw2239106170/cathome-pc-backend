package com.cathome.service;

import com.cathome.pojo.cat.CatPojo;
import com.cathome.pojo.cat.PageBean;

import java.util.List;

public interface CatService {
    public PageBean selectCat(Integer page, Integer pageSize, String catName, String state);

    List<CatPojo> searchById(Integer id);

    void updateCat(CatPojo catPojo);

    void deleteCat(Integer id);

    void insertCat(CatPojo catPojo);
}
