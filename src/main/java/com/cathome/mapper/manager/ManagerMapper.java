package com.cathome.mapper.manager;

import com.cathome.pojo.manager.ManagerPojo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 管理员查询数据层
 */
public interface ManagerMapper {
    /**
     * 登录查询
     * @param managerName
     * @param password
     * @return
     */
    @Select("select * from cat_manager where manager")
    public List<ManagerPojo> managerList(String managerName, String password);
}
