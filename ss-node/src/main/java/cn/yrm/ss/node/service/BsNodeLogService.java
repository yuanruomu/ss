package cn.yrm.ss.node.service;

import java.util.List;

import cn.yrm.ss.page.PageParameter;
import cn.yrm.ss.node.domain.BsNodeLog;

public interface BsNodeLogService {

    public List<BsNodeLog> findBsNodeLogPage(String userName, String nodeCode, String nodeName, PageParameter page);

}
