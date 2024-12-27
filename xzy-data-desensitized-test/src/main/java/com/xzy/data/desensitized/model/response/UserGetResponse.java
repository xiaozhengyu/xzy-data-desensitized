package com.xzy.data.desensitized.model.response;

import com.xzy.data.desensitized.Desensitized;
import com.xzy.data.desensitized.DesensitizedTypeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author xzy.xiao
 * @since 2024/12/25  17:17
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserGetResponse implements Serializable {

    private static final long serialVersionUID = 763442505810739769L;

    @Desensitized(type = DesensitizedTypeEnum.USER_ID)
    private String userId;
    @Desensitized(type = DesensitizedTypeEnum.CHINESE_NAME)
    private String chineseName;
    @Desensitized(type = DesensitizedTypeEnum.ID_CARD)
    private String idCard;
    @Desensitized(type = DesensitizedTypeEnum.FIXED_PHONE)
    private String fixedPhone;
    @Desensitized(type = DesensitizedTypeEnum.MOBILE_PHONE)
    private String mobilePhone;
    @Desensitized(type = DesensitizedTypeEnum.ADDRESS)
    private String address;
    @Desensitized(type = DesensitizedTypeEnum.EMAIL)
    private String email;
    @Desensitized(type = DesensitizedTypeEnum.PASSWORD)
    private String password;
    @Desensitized(type = DesensitizedTypeEnum.CAR_LICENSE)
    private String carLicense;
    @Desensitized(type = DesensitizedTypeEnum.BANK_CARD)
    private String bankCard;
    @Desensitized(type = DesensitizedTypeEnum.IPV4)
    private String ipv4;
    @Desensitized(type = DesensitizedTypeEnum.IPV6)
    private String ipv6;
}
