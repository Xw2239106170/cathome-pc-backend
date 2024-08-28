package com.cathome.pojo.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 管理员实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManagerPojo {
    private Short id;
    private String managerName;
    private String password;
    private String name;
    private Short gender;
    private String image;
    private LocalDate entrydata;
}
