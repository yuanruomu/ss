package cn.yrm.ss.user.service;

import cn.yrm.ss.user.domain.AuthUser;


/**
 * 用户管理业务层接口
 * 
 * @author Yuanruomu
 */
public interface AuthUserService {


    public AuthUser getAuthUserById(long userId);

    public int getUserNameCount(String userName);

    public void updateUserPassword(long userId, String password);

    public int insertAuthUser(AuthUser authUser);

    public int updateUserState(long userId, int userState);
    
    public AuthUser getAuthUserByUserName(String userName);
    
}
