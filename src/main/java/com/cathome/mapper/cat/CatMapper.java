package com.cathome.mapper.cat;

import com.cathome.pojo.cat.CatPojo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CatMapper {
    /**
     * 查询所有猫咪信息
     * @return
     */
    @Select("select * from cat_common;")
    List<CatPojo> selectCat();
}
