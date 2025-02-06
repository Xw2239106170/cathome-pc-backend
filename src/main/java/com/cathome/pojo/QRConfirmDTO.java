package com.cathome.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRConfirmDTO {
    private Long id;                // 二维码的 ID
    private String qrCode;          // 二维码内容
    private QRCodeStatus status;    // 二维码状态
    private Long userId;            // 用户 ID
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime expireTime; // 过期时间
}
