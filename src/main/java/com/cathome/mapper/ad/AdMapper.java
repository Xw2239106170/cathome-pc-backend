package com.cathome.mapper.ad;

import com.cathome.pojo.ad.AdPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdMapper {
    /**
     * 分页查询
     * @param adName
     * @param brandName
     * @return
     */
    List<AdPojo> adList(String adName, String brandName);

    /**
     * 根据id查询数据库
     * @param id
     * @return
     */
    @Select("select * from cat_ad where id = #{id};")
    List<AdPojo> adsById(Integer id);

    /**
     * 根据id删除猫咪
     * @param id
     */
    @Delete("delete from cat_ad where id = #{id};")
    void adsDeleteById(Integer id);

    /**
     * 更新广告数据
     * @param adPojo
     */
    @Update("update cat_ad set ad_name = #{adName} ,brand_name=#{brandName},price=#{price}, address =#{address},image=#{image} where id = #{id};")
    void adsUpdate(AdPojo adPojo);

    /**
     * 新增广告数据
     * @param adPojo
     */
    @Insert("INSERT INTO cat_ad (ad_name, brand_name, address, price,image) " +
            "VALUES (#{adName}, #{brandName}, #{address}, #{price}, #{image});")
    void adsInsert(AdPojo adPojo);

    /**
     * 批量删除
     * @param ids
     */
    void adsDelete(List<Integer> ids);
}