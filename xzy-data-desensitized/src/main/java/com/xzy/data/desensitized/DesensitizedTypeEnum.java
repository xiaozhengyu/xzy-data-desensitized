package com.xzy.data.desensitized;

import cn.hutool.core.util.DesensitizedUtil;
import cn.hutool.core.util.StrUtil;

/**
 * 脱敏类型
 *
 * @author xzy.xiao
 * @since 2024/12/27  9:25
 */
public enum DesensitizedTypeEnum {
    /**
     * 自定义
     */
    CUSTOM {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return StrUtil.hide(str, startInclude, endExclude);
        }
    },
    /**
     * 用户id
     */
    USER_ID {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.USER_ID);
        }
    },
    /**
     * 中文名
     */
    CHINESE_NAME {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.CHINESE_NAME);
        }
    },
    /**
     * 身份证号
     */
    ID_CARD {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.ID_CARD);
        }
    },
    /**
     * 固定电话
     */
    FIXED_PHONE {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.FIXED_PHONE);
        }
    },
    /**
     * 移动电话
     */
    MOBILE_PHONE {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.MOBILE_PHONE);
        }
    },
    /**
     * 地址
     */
    ADDRESS {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.ADDRESS);
        }
    },
    /**
     * 邮件
     */
    EMAIL {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.EMAIL);
        }
    },
    /**
     * 密码
     */
    PASSWORD {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.PASSWORD);
        }
    },
    /**
     * 车牌号
     */
    CAR_LICENSE {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.CAR_LICENSE);
        }
    },
    /**
     * 银行卡号
     */
    BANK_CARD {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.BANK_CARD);
        }
    },
    /**
     * IPV4
     */
    IPV4 {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.IPV4);
        }
    },
    /**
     * IPV6
     */
    IPV6 {
        @Override
        public String desensitize(String str, Integer startInclude, Integer endExclude) {
            return DesensitizedUtil.desensitized(str, DesensitizedUtil.DesensitizedType.IPV6);
        }
    };

    public abstract String desensitize(String str, Integer startInclude, Integer endExclude);
}
