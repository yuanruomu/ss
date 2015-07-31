package cn.yrm.ss.node.persistence;

import java.util.List;

import cn.yrm.ss.page.PageParameter;
import org.apache.ibatis.annotations.Param;
import cn.yrm.ss.node.domain.BsNodeLog;

/**
 * 基站修改日志持久层 mybatis映射
 * 
 * @author Yuanruomu
 */
public interface BsNodeLogMapper {

    /** 获取基站修改日志列表 */
    public List<BsNodeLog> findBsNodeLogPage(@Param("userName") String userName,
                                             @Param("nodeCode") String nodeCode, @Param("nodeName") String nodeName, @Param("page") PageParameter page);

    /** 插入一个基站修改日志 */
    public int insertBsNodeLog(BsNodeLog bsNodeLog);

}
