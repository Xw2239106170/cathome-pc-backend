package com.cathome.service.impl;

import com.cathome.mapper.code.QRCodeMapper;
import com.cathome.pojo.QRCodeRecord;
import com.cathome.pojo.QRCodeStatus;
import com.cathome.pojo.QRConfirmDTO;
import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.service.QRLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j

public class QRLoginServiceImpl implements QRLoginService {

    @Autowired
    private QRCodeMapper qrCodeMapper;

    // 生成二维码并保存记录
    @Override
    public String generateQRCode() {
        String qrCode = UUID.randomUUID().toString();
        QRCodeRecord record = new QRCodeRecord();
        record.setQrCode(qrCode);
        record.setStatus(QRCodeStatus.WAITING);
        record.setExpireTime(LocalDateTime.now().plusMinutes(5));
        qrCodeMapper.insert(record);
        return qrCode;
    }

    @Override
    // 检查二维码状态
    public QRCodeStatus checkQRCodeStatus(String qrCode) {
        QRCodeRecord record = qrCodeMapper.selectByQRCode(qrCode);
        if (record == null || record.getExpireTime().isBefore(LocalDateTime.now())) {
            return QRCodeStatus.EXPIRED;
        }
        return record.getStatus();
    }

    // 确认登录
    @Override
    public void confirmQRLogin(QRConfirmDTO confirmDTO) {
        QRCodeRecord record = qrCodeMapper.selectByQRCode(confirmDTO.getQrCode());
        log.info("查询的信息{}", record);
        if (record != null && !record.getExpireTime().isBefore(LocalDateTime.now())
        ) {
            record.setStatus(QRCodeStatus.CONFIRMED);
            record.setUserId(confirmDTO.getUserId());
            qrCodeMapper.updateById(record);
            log.info("更改的信息{}", record);
        }
    }

    /**
     * 查询二维码登录人员信息
     * @param codeUserName
     * @return
     */
    @Override
    public ManagerPojo codeUserList(String codeUserName) {
        return qrCodeMapper.codeList(codeUserName);
    }
}
