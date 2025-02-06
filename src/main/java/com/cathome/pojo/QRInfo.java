package com.cathome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRInfo {
    private Integer userId;
    private String qrImage;
    private String qrUUID;
}
