package cn.yrm.ss.node.service;

import java.util.List;
import cn.yrm.ss.page.PageParameter;
import cn.yrm.ss.node.domain.BsNode;

public interface BsNodeService {

    public List<BsNode> findBsNodePage(String nodeCode, String nodeName, PageParameter page);

    public List<BsNode> findNearBsNodePage(double longitude, double latitude, int range, PageParameter page);

    public BsNode getBsNodeById(int nodeId);

    public BsNode getBsNodeByCode(String nodeCode);

    public int updateBsNode(BsNode bsNode, String user) throws Exception;

    public int insertBsNode(BsNode bsNode);
}
