package com.cathome.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录与前端数据传输
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginVo {
    private String managerName;
    private String password;
}
