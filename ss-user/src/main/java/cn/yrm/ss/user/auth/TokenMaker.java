package cn.yrm.ss.user.auth;

import cn.yrm.ss.user.constant.UserConstants;
import cn.yrm.ss.utils.EncryptUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TokenMaker {

    private static final Logger log = LoggerFactory.getLogger(TokenMaker.class);

    /*
     * 有效时间至,userId
     */
    public static String encodeToken(String userId) {

        long tokenTime = System.currentTimeMillis() + UserConstants.DEFAULT_TOKEN_EXPIRES_IN * 1000;

        String tokenStr = tokenTime + "," + userId;

        log.debug("token生成加密前:" + tokenStr);
        String encryptToken = null;
        try {
            encryptToken = EncryptUtil.desedeEncoder(tokenStr, UserConstants.TOKEN_KEY);
            log.debug("token生成加密后:" + encryptToken);
            return encryptToken;
        } catch (Exception e) {
            log.error("token加密报错", e);
        }
        return encryptToken;
    }

}
