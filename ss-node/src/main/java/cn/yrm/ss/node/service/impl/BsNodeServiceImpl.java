package cn.yrm.ss.node.service.impl;

import java.lang.reflect.Field;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yrm.ss.page.PageParameter;
import cn.yrm.ss.node.domain.BsNode;
import cn.yrm.ss.node.domain.BsNodeLog;
import cn.yrm.ss.node.persistence.BsNodeLogMapper;
import cn.yrm.ss.node.persistence.BsNodeMapper;
import cn.yrm.ss.node.service.BsNodeService;

@Service
public class BsNodeServiceImpl implements BsNodeService {

    @Autowired
    private BsNodeMapper bsNodeMapper;
    @Autowired
    private BsNodeLogMapper bsNodeLogMapper;

    @Override
    public List<BsNode> findBsNodePage(String nodeCode, String nodeName, PageParameter page) {
        return bsNodeMapper.findBsNodePage(nodeCode, nodeName, page);
    }

    @Override
    public List<BsNode> findNearBsNodePage(double longitude, double latitude, int range, PageParameter page) {
        return bsNodeMapper.findNearBsNodePage(longitude, latitude, range, page);
    }

    @Override
    public BsNode getBsNodeById(int nodeId) {
        return bsNodeMapper.getBsNodeById(nodeId);
    }

    @Override
    public BsNode getBsNodeByCode(String nodeCode) {
        return bsNodeMapper.getBsNodeByCode(nodeCode);
    }


    @Transactional(rollbackFor = Exception.class)
    public int updateBsNode(BsNode bsNode, String user) throws Exception {

        boolean hasEdit = false;
        // 写LOG
        BsNode oldBsNode = bsNodeMapper.getBsNodeById(bsNode.getNodeId());
        if (oldBsNode == null) {
            return -1;
        }
        Field[] fields = BsNode.class.getDeclaredFields();
        for (Field field : fields) {
            String nameKey = field.getName();
            if ("createAt".equals(nameKey) || "updateAt".equals(nameKey) || "serialVersionUID".equals(nameKey)) {
                continue;
            }
            field.setAccessible(true);
            Object oldValue = field.get(oldBsNode);
            Object newValue = field.get(bsNode);
            if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null)
                    || (oldValue != null && newValue != null && !oldValue.toString().equals(newValue.toString()))) {
                // 写更新记录
                BsNodeLog bsNodeLog = new BsNodeLog();
                bsNodeLog.setNodeId(bsNode.getNodeId());
                bsNodeLog.setNodeCode(bsNode.getNodeCode());
                bsNodeLog.setNodeName(bsNode.getNodeName());
                bsNodeLog.setColumnName(nameKey);
                bsNodeLog.setOldValue(oldValue == null ? null : oldValue.toString());
                bsNodeLog.setNewValue(newValue == null ? null : newValue.toString());
                bsNodeLog.setEditUser(user);
                bsNodeLogMapper.insertBsNodeLog(bsNodeLog);
                hasEdit = true;
            }
        }
        if (hasEdit) {
            return bsNodeMapper.updateBsNode(bsNode);
        }
        return 0;
    }

    @Transactional
    public int insertBsNode(BsNode bsNode) {
        return bsNodeMapper.insertBsNode(bsNode);
    }

}
