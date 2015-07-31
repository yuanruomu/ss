package cn.yrm.ss.node.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.yrm.ss.page.PageParameter;
import cn.yrm.ss.node.domain.BsNodeLog;
import cn.yrm.ss.node.persistence.BsNodeLogMapper;
import cn.yrm.ss.node.service.BsNodeLogService;

@Service
public class BsNodeLogServiceImpl implements BsNodeLogService {

    @Autowired
    private BsNodeLogMapper bsNodeLogMapper;

    public List<BsNodeLog> findBsNodeLogPage(String userName, String nodeCode, String nodeName, PageParameter page) {
        return bsNodeLogMapper.findBsNodeLogPage(userName, nodeCode, nodeName, page);
    }

}
