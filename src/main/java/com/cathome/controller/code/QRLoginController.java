package com.cathome.controller.code;

import com.aliyun.oss.model.MultipartUpload;
import com.cathome.pojo.*;
import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.service.QRLoginService;
import com.cathome.utils.AliOSSUtils;
import com.cathome.utils.JwtUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/qr")
@Slf4j
public class QRLoginController {

    @Autowired
    private QRLoginService qrLoginService;

    // 生成二维码接口
    @GetMapping("/generate")
    public Result generateQRCode() {
        String qrContent = qrLoginService.generateQRCode();
        // 创建二维码数据对象
        String qrImage = generateQRCodeImage(qrContent);
//        封装二维码信息
        QRInfo qrInfo = new QRInfo();
        qrInfo.setQrImage(qrImage);
        qrInfo.setQrUUID(qrContent);

        return Result.success(qrInfo);
    }

    // 轮询二维码状态接口
    @GetMapping("/check/{qrCode}")
    public Result checkQRStatus(@PathVariable String qrCode) {
        QRCodeStatus status = qrLoginService.checkQRCodeStatus(qrCode);
        return Result.success(status);
    }

    // 手机扫码确认接口
    @PostMapping("/confirm")
    public Result confirmLogin(@RequestBody QRConfirmDTO confirmDTO) {

        confirmDTO.setUserId((long) (new Random().nextInt(90000) + 10000));

        log.info("输入信息{}", confirmDTO);

        qrLoginService.confirmQRLogin(confirmDTO);

        //绑定人员登录
        ManagerPojo codeUser = qrLoginService.codeUserList("airport");

        //生成jwt令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put("managerName", codeUser.getManagerName());
        claims.put("password", codeUser.getPassword());
        String jwt = JwtUtils.generateJwt(claims);

        //开始封装登录成功信息
        QRCOdeUser qrcOdeUser = new QRCOdeUser();
        qrcOdeUser.setJwt(jwt);
        qrcOdeUser.setManagerPojo(codeUser);
        return Result.success(qrcOdeUser);
    }

    private String generateQRCodeImage(String qrId) {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(
                    qrId,
                    BarcodeFormat.QR_CODE,
                    200,
                    200
            );

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
            return Base64.getEncoder().encodeToString(outputStream.toByteArray());

        } catch (Exception e) {
            throw new RuntimeException("Generate QR code failed", e);
        }
    }
}