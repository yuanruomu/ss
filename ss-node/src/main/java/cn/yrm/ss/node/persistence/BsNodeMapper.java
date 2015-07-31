package cn.yrm.ss.node.persistence;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import cn.yrm.ss.page.PageParameter;
import cn.yrm.ss.node.domain.BsNode;

/**
 * 基站管理持久层 mybatis映射
 * 
 * @author Yuanruomu
 */
public interface BsNodeMapper {

    /** 获取基站信息列表 */
    public List<BsNode> findBsNodePage(@Param("nodeCode") String nodeCode,
                                       @Param("nodeName") String nodeName, @Param("page") PageParameter page);

    /** 查询附近的基站信息列表 */
    public List<BsNode> findNearBsNodePage(@Param("longitude") double longitude,
                                           @Param("latitude") double latitude, @Param("range") int range, @Param("page") PageParameter page);

    /** 查询一个基站信息 */
    public BsNode getBsNodeById(@Param("nodeId") int nodeId);

    /** 查询一个基站信息 */
    public BsNode getBsNodeByCode(@Param("nodeCode") String nodeCode);

    /** 更新一个基站信息 */
    public int updateBsNode(BsNode bsNode);

    /** 插入一个基站信息 */
    public int insertBsNode(BsNode bsNode);

}
