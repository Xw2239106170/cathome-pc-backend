package com.cathome.mapper.cat;

import com.cathome.pojo.cat.CatPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CatMapper {
    /**
     * 查询所有猫咪信息
     * @return
     */
//    @Select("select * from cat_common;")
    List<CatPojo> selectCat(String catName, String state);

    /**
     * 根据id查询猫咪信息
     * @param id
     * @return
     */
    @Select("select * from cat_common where id = #{id};")
    List<CatPojo> selectById(Integer id);

    /**
     * 更新小猫信息
     * @param catPojo
     */
    @Update("update cat_common set cat_name = #{catName} ,age=#{age},state=#{state}, health = #{health}, address =#{address},image=#{image},entrydate= #{entrydate} where id = #{id};")
    void updateCat (CatPojo catPojo);

    /**
     * 根据id查询猫咪，但是有问题
     * @param id
     */
    @Delete("delete from cat_common where id = #{id};")
    void deleteCat(Integer id);

    /**
     * 新增猫咪
     * @param catPojo
     */
    @Insert("INSERT INTO cat_common (cat_name, age, state, health, address, image, entrydate) " +
            "VALUES (#{catName}, #{age}, #{state}, #{health}, #{address}, #{image}, #{entrydate});")
    void insertCat(CatPojo catPojo);
}
