package com.xzy.data.desensitized.model.response;

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
public class UserListResponse implements Serializable {

    private static final long serialVersionUID = 763442505810739769L;

    private String userId;
    private String chineseName;
    private String idCard;
    private String fixedPhone;
    private String mobilePhone;
    private String address;
    private String email;
    private String password;
    private String carLicense;
    private String bankCard;
    private String ipv4;
    private String ipv6;
}
