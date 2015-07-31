package cn.yrm.ss.user.persistence;

import org.apache.ibatis.annotations.Param;

import cn.yrm.ss.user.domain.AuthUser;

/**
 * 用户管理持久层 mybatis映射
 * 
 * @author Yuanruomu
 */
public interface AuthUserMapper {

    /** 获取用户信息 */
    public AuthUser getAuthUserById(@Param("userId") long userId);

    /** 根据用户名查询是否有此用户 */
    public int getUserNameCount(@Param("userName") String userName);

    /** 插入一个新用户 */
    public int insertAuthUser(AuthUser authUser);

    /** 重置密码 */
    void updateUserPassword(@Param("userId") long userId, @Param("password") String password);

    /** 更新用户状态 */
    public int updateUserState(@Param(value = "userId") long userId, @Param(value = "userState") int userState);
    
    /**根据用户名查询用户信息*/
    public AuthUser getAuthUserByUserName(@Param("userName") String userName);
       
}
