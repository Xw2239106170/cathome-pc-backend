package com.cathome.mapper.code;

import com.cathome.pojo.QRCodeRecord;
import com.cathome.pojo.QRCodeStatus;
import com.cathome.pojo.manager.ManagerPojo;
import com.cathome.pojo.vo.LoginVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface QRCodeMapper {
    /**
     * 插入二维码记录
     */
    int insert(QRCodeRecord record);

    /**
     * 根据二维码查询记录
     */
    QRCodeRecord selectByQRCode(@Param("qrCode") String qrCode);

    /**
     * 更新记录
     */
    int updateById(QRCodeRecord record);

    /**
     * 删除过期的二维码记录
     */
    int deleteExpired(@Param("expireTime") LocalDateTime expireTime);

    /**
     * 更新二维码状态
     */
    int updateStatus(@Param("qrCode") String qrCode,
                     @Param("status") QRCodeStatus status,
                     @Param("userId") Long userId);

    /**
     * 查询二维码登录人员信息
     * @param codeUserName
     * @return
     */
    @Select("select * from cat_manager where manager_name = #{codeUserName}")
    ManagerPojo codeList(String codeUserName);
}
