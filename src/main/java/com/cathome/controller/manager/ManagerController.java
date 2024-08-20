package com.cathome.controller.manager;

import com.cathome.pojo.Result;
import com.cathome.pojo.vo.LoginVo;
import com.cathome.service.ManagerService;
import com.cathome.service.impl.ManagerServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 管理员web层
 *
 */
@RestController
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class ManagerController {
    @Autowired
    private ManagerService managerService;

}
