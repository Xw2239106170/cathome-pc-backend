package com.cathome.pojo;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "qr_codes")
public class QRCode {
    @Id
    private String id;

    @Enumerated(EnumType.STRING)
    private QRCodeStatus status;

    private LocalDateTime createTime;

    private LocalDateTime expireTime;

    private String userId;

    @Version
    private Long version;
}