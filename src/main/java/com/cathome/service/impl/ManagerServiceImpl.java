package com.cathome.service.impl;

import com.cathome.mapper.manager.ManagerMapper;
import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.pojo.vo.LoginVo;
import com.cathome.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 管理员数据处理
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 登录接口
     * @param loginVo 前端数据接收实体
     * @return
     */
    @Override
    public List<ManagerPojo> manageList(LoginVo loginVo) {
        return managerMapper.managerList(loginVo);
    }

    /**
     * 注册逻辑处理
     * @param loginVo
     */
    @Override
    public void insertList(LoginVo loginVo) {
        managerMapper.insertList(loginVo);
    }

    /**
     * 判断是否注册
     * @param loginVo
     * @return
     */
    @Override
    public List<ManagerPojo> selectManager(LoginVo loginVo){
        return managerMapper.RegisterList(loginVo);
    }
}
