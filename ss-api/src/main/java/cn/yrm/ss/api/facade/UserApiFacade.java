package cn.yrm.ss.api.facade;
import java.util.Locale;

import cn.yrm.ss.api.code.EnumMsgCode;
import cn.yrm.ss.user.auth.TokenMaker;
import cn.yrm.ss.user.domain.AuthUser;
import cn.yrm.ss.user.service.AuthUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import cn.yrm.ss.api.req.ClientRequest;
import cn.yrm.ss.api.rsp.UserLoginResponse;
import cn.yrm.ss.user.utils.PasswordEncoder;


@Service
public class UserApiFacade {

    private static final Logger log = LoggerFactory.getLogger(UserApiFacade.class);

    @Autowired
    AuthUserService authUserService;
    @Autowired
    private MessageSource messageSource;

    /**
     * 登陆
     * 
     * @param clientRequest
     * @return
     * @throws Exception
     */
    public UserLoginResponse userlogin(ClientRequest clientRequest) {
        log.info("login execute==============================");

        UserLoginResponse userLoginRsp = new UserLoginResponse();
        String userName = clientRequest.getUserName();
        String password = clientRequest.getPassword();

        AuthUser user = authUserService.getAuthUserByUserName(userName);
        if (user == null) {
            userLoginRsp.setResult(false);
            userLoginRsp.setErrorCode(EnumMsgCode.ECOM0003.stringValue());
            userLoginRsp
                    .setReason(messageSource.getMessage(EnumMsgCode.ECOM0003.stringValue(), null, Locale.getDefault()));
            return userLoginRsp;
        }
        if (!user.getPassword().equals(PasswordEncoder.encode(userName, password))) {
            userLoginRsp.setResult(false);
            userLoginRsp.setErrorCode(EnumMsgCode.ECOM0004.stringValue());
            userLoginRsp
                    .setReason(messageSource.getMessage(EnumMsgCode.ECOM0004.stringValue(), null, Locale.getDefault()));
            return userLoginRsp;
        }
        // 生产Token
        userLoginRsp.setToken(TokenMaker.encodeToken(user.getUserId()));
        return userLoginRsp;
    }

    /**
     * 登陆
     * 
     * @param clientRequest
     * @return
     * @throws Exception
     */
    public UserLoginResponse usercreate(ClientRequest clientRequest) {
        log.info("login execute==============================");

        UserLoginResponse userLoginRsp = new UserLoginResponse();
        String userName = clientRequest.getUserName();
        String password = clientRequest.getPassword();

        int num = authUserService.getUserNameCount(userName);
        if (num > 0) {
            userLoginRsp.setResult(false);
            userLoginRsp.setErrorCode(EnumMsgCode.ECOM0007.stringValue());
            userLoginRsp.setReason(messageSource.getMessage(EnumMsgCode.ECOM0007.stringValue(), new Object[] { userName },
                    Locale.getDefault()));
            return userLoginRsp;
        }
        AuthUser user = new AuthUser();
        user.setUserName(userName);
        user.setPassword(password);
        int result = authUserService.insertAuthUser(user);
        if (result != 1) {
            userLoginRsp.setResult(false);
            userLoginRsp.setErrorCode(EnumMsgCode.ECOM0006.stringValue());
            userLoginRsp
                    .setReason(messageSource.getMessage(EnumMsgCode.ECOM0006.stringValue(), null, Locale.getDefault()));
            return userLoginRsp;
        }
        // 生产Token
        userLoginRsp.setToken(TokenMaker.encodeToken(user.getUserId()));
        return userLoginRsp;
    }

}
