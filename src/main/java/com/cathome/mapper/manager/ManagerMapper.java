package com.cathome.mapper.manager;

import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.pojo.vo.LoginVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 管理员查询数据层
 */

@Mapper
public interface ManagerMapper {
    /**
     * 登录查询
     * @return
     */
    @Select("select * from cat_manager where manager_name = #{managerName} and password = #{password};")
    List<ManagerPojo> managerList(LoginVo loginVo);

    /**
     * 注册功能
     * @param loginVo
     */
    @Insert("insert into cat_manager (manager_name, password, entrydata) values (#{managerName}, #{password}, now());")
    void insertList(LoginVo loginVo);

    /**
     * 判断是否注册
     * @param loginVo
     * @return
     */
    @Select("select * from cat_manager where manager_name = #{managerName}")
    List<ManagerPojo> RegisterList(LoginVo loginVo);

    /**
     * 根据用户名查询用户详细个人信息
     * @param managerName
     * @return
     */
    @Select("select * from cat_manager where manager_name = #{managerName};")
    List<ManagerPojo> managerDetail(String managerName);

    @Update("update cat_manager set manager_name = #{managerName} ,name=#{name},password=#{password}, gender =#{gender},image=#{image} where id = #{id};")
    void managerUpdate(ManagerPojo managerPojo);
}
