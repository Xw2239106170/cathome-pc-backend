package com.cathome.controller.manager;

import com.cathome.pojo.Result;
import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.pojo.vo.LoginVo;
import com.cathome.service.ManagerService;
import com.cathome.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.awt.event.WindowFocusListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "*")
@Transactional(rollbackFor = Exception.class)
public class ManagerDoorController {
    @Autowired
    private ManagerService managerService;

    /**
     * 登录接口
     * @param loginVo
     * @return
     */
    @PostMapping("/login")
    public Result managerList(@RequestBody LoginVo loginVo){
        List<ManagerPojo> managerPojoList = managerService.manageList(loginVo);
        log.info("登录查询的数据{}", managerPojoList);
        if(managerPojoList == null) return Result.error("还未登录哦~");

        //绑定管理员的登录信息
        Map<String, Object> claims = new HashMap<>();
        claims.put("managerName", loginVo.getManagerName());
        claims.put("password", loginVo.getPassword());

        //生成jwt令牌
        String jwt = JwtUtils.generateJwt(claims);

        return Result.success(jwt);
    }

    /**
     * 注册
     * @param loginVo
     * @return
     */
    @PostMapping("/reg")
    public Result insertList(@RequestBody LoginVo loginVo){
        List<ManagerPojo> managerPojoList = managerService.selectManager(loginVo);
        log.info("查询到的信息{}", managerPojoList);
        //注册失败
        if(!managerPojoList.isEmpty()) return Result.error("用户名已经被占用~");
        //注册成功
        managerService.insertList(loginVo);

        return Result.success("注册成功！");
    }
}
