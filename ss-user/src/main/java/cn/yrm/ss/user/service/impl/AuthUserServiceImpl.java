package cn.yrm.ss.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yrm.ss.user.utils.PasswordEncoder;
import cn.yrm.ss.user.domain.AuthUser;
import cn.yrm.ss.user.persistence.AuthUserMapper;
import cn.yrm.ss.user.service.AuthUserService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户管理
 * 
 * @author Yuanruomu
 */
@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserMapper authUserMapper;

    /**
     * 重置用户密码
     * 
     * @param userId
     *            用户ID
     * @param password
     *            密码
     * @return
     */
    @Transactional
    public void updateUserPassword(long userId, String password) {
        authUserMapper.updateUserPassword(userId, password);
    }

    /**
     * 获取用户信息
     * 
     * @param userId
     *            用户ID
     * @return
     */
    public AuthUser getAuthUserById(long userId) {
        return authUserMapper.getAuthUserById(userId);
    }

    /**
     * 更新用户状态
     * 
     * @param userId
     *            用户ID
     * @param userState
     *            用户状态
     * @return
     */
    @Transactional
    public int updateUserState(long userId, int userState) {
        return authUserMapper.updateUserState(userId, userState);
    }

    /**
     * 根据用户名查询数据库是否有重复
     * 
     * @param userName
     *            用户名
     * @return
     */
    public int getUserNameCount(String userName) {
        return authUserMapper.getUserNameCount(userName);
    }

    /**
     * 插入一条用户记录
     * 
     * @param authUser
     * @return
     */
    @Transactional
    public int insertAuthUser(AuthUser authUser) {
        // 密码加密
        authUser.setPassword(PasswordEncoder.encode(authUser.getUserName(), authUser.getPassword()));
        return authUserMapper.insertAuthUser(authUser);
    }

    /**
     * 根据用户名查询用户信息
     */
    public AuthUser getAuthUserByUserName(String userName) {
        AuthUser authUser = authUserMapper.getAuthUserByUserName(userName);
        return authUser;
    }
}
