package com.cathome.service;

import com.cathome.pojo.QRCodeStatus;
import com.cathome.pojo.QRConfirmDTO;
import com.cathome.pojo.manager.ManagerPojo;

import java.util.List;

public interface QRLoginService {
    String generateQRCode();

    QRCodeStatus checkQRCodeStatus(String qrCode);
    void confirmQRLogin(QRConfirmDTO confirmDTO);

    ManagerPojo codeUserList(String codeUserName);
}
