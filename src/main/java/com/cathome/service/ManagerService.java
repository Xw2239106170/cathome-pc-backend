package com.cathome.service;

import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.pojo.vo.LoginVo;

import java.util.List;

/**
 * 管理员数据处理接口层
 */
public interface ManagerService {
    /**
     * 登录查询接口
     */
    List<ManagerPojo> manageList(LoginVo loginVo);

    /**
     * 注册接口
     * @param loginVo
     */
    void insertList(LoginVo loginVo);

    /**
     * 判断是否注册
     * @param loginVo
     * @return
     */
    List<ManagerPojo> selectManager(LoginVo loginVo);

    /**
     * 查询详细用户信息
     * @param managerName
     * @return
     */
    List<ManagerPojo> selectDetailManager(String managerName);

    void managerUpdate(ManagerPojo managerPojo);
}
