package com.cathome.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 扫码状态
 */
@Data
public class QRCodeRecord {
    private Long id;
    private String qrCode;
    private QRCodeStatus status;
    private Long userId;
    private LocalDateTime createTime;
    private LocalDateTime expireTime;
}
