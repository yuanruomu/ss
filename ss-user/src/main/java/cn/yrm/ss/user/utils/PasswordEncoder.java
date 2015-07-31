package cn.yrm.ss.user.utils;

import cn.yrm.ss.utils.MD5Crypt;

public class PasswordEncoder {

    /**
     * 密码计算存储核心类
     */
    public static String encode(String userName, String passwd) {
        return MD5Crypt.encode(passwd, userName);
    }
}
