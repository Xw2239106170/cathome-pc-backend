package com.cathome.pojo;

import com.cathome.pojo.manager.ManagerPojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRCOdeUser {
    private ManagerPojo managerPojo;
    private String jwt;
}
