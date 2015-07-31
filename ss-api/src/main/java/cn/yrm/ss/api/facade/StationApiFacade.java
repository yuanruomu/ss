package cn.yrm.ss.api.facade;

import java.util.List;
import java.util.Locale;

import cn.yrm.ss.api.code.EnumMsgCode;
import cn.yrm.ss.api.constant.ApiConstants;
import cn.yrm.ss.api.req.ClientRequest;
import cn.yrm.ss.api.rsp.ClientResponse;
import cn.yrm.ss.api.rsp.StationInfoResponse;
import cn.yrm.ss.api.rsp.StationListResponse;
import cn.yrm.ss.api.rsp.StationLogListResponse;
import cn.yrm.ss.node.domain.BsNode;
import cn.yrm.ss.node.domain.BsNodeLog;
import cn.yrm.ss.node.service.BsNodeLogService;
import cn.yrm.ss.node.service.BsNodeService;
import cn.yrm.ss.page.PageParameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class StationApiFacade {

    private static final Logger log = LoggerFactory.getLogger(StationApiFacade.class);

    @Autowired
    private BsNodeService bsNodeService;
    @Autowired
    private BsNodeLogService bsNodeLogService;
    @Autowired
    private MessageSource messageSource;

    /**
     * 获取基站列表
     *
     * @param clientRequest
     * @return
     * @throws Exception
     */
    public StationListResponse stationlistquery(ClientRequest clientRequest) {
        log.info("stationlistquery execute==============================");
        StationListResponse stationListRsp = new StationListResponse();
        PageParameter page = new PageParameter(clientRequest.getPage(), clientRequest.getPageSize());
        String nodeCode = clientRequest.getNodeCode();
        String nodeName = clientRequest.getNodeName();
        List<BsNode> netList = bsNodeService.findBsNodePage(nodeCode, nodeName, page);
        stationListRsp.setCurrentPage(page.getCurrentPage());
        stationListRsp.setTotalCount(page.getTotalCount());
        stationListRsp.setTotalPage(page.getTotalPage());
        stationListRsp.setPageSize(page.getPageSize());
        stationListRsp.setStationList(netList);
        return stationListRsp;
    }

    /**
     * 获取附近的基站列表
     *
     * @param clientRequest
     * @return
     * @throws Exception
     */
    public StationListResponse stationnearquery(ClientRequest clientRequest) {
        log.info("stationnearquery execute==============================");
        int range = clientRequest.getRange() != null ? clientRequest.getRange()
                : ApiConstants.DEFAULT_NEAR_RANGE_MIN;
        Double longitude = clientRequest.getLongitude();
        Double latitude = clientRequest.getLatitude();
        StationListResponse stationListRsp = new StationListResponse();
        PageParameter page = new PageParameter(clientRequest.getPage(), clientRequest.getPageSize());
        List<BsNode> netList = bsNodeService.findNearBsNodePage(longitude, latitude, range, page);
        stationListRsp.setCurrentPage(page.getCurrentPage());
        stationListRsp.setTotalCount(page.getTotalCount());
        stationListRsp.setTotalPage(page.getTotalPage());
        stationListRsp.setPageSize(page.getPageSize());
        stationListRsp.setStationList(netList);
        return stationListRsp;
    }

    public StationInfoResponse stationget(ClientRequest clientRequest) {
        log.info("stationget execute==============================");
        StationInfoResponse stationInfoRsp = new StationInfoResponse();
        Integer nodeId = clientRequest.getNodeId();
        if (nodeId != null) {
            BsNode bsNode = bsNodeService.getBsNodeById(nodeId);
            stationInfoRsp.setStationInfo(bsNode);
        } else {
            String nodeCode = clientRequest.getNodeCode();
            BsNode bsNode = bsNodeService.getBsNodeByCode(nodeCode);
            stationInfoRsp.setStationInfo(bsNode);
        }
        return stationInfoRsp;
    }

    public ClientResponse stationcreate(ClientRequest clientRequest) {
        log.info("stationcreate execute==============================");

        BsNode bsNode = new BsNode();
        bsNode.setAEomsAccount(clientRequest.getaEomsAccount());
        bsNode.setBEomsAccount(clientRequest.getbEomsAccount());
        bsNode.setNodeCode(clientRequest.getNodeCode());
        bsNode.setNodeName(clientRequest.getNodeName());
        bsNode.setLatitude(clientRequest.getLatitude());
        bsNode.setLongitude(clientRequest.getLongitude());

        ClientResponse clientRsp = new ClientResponse();
        int result = bsNodeService.insertBsNode(bsNode);
        if (result != 1) {
            clientRsp.setResult(false);
            clientRsp.setErrorCode(EnumMsgCode.ECOM0006.stringValue());
            clientRsp
                    .setReason(messageSource.getMessage(EnumMsgCode.ECOM0006.stringValue(), null, Locale.getDefault()));
        }
        return clientRsp;

    }

    public ClientResponse stationupdate(ClientRequest clientRequest) throws Exception {
        log.info("stationcreate execute==============================");
        ClientResponse clientRsp = new ClientResponse();
        BsNode bsNode = new BsNode();
        bsNode.setAEomsAccount(clientRequest.getaEomsAccount());
        bsNode.setBEomsAccount(clientRequest.getbEomsAccount());
        bsNode.setNodeCode(clientRequest.getNodeCode());
        bsNode.setNodeName(clientRequest.getNodeName());
        bsNode.setLatitude(clientRequest.getLatitude());
        bsNode.setLongitude(clientRequest.getLongitude());
        bsNode.setNodeId(clientRequest.getNodeId());

        int result = bsNodeService.updateBsNode(bsNode, clientRequest.getUserName());
        if (result != 1) {
            clientRsp.setResult(false);
            clientRsp.setErrorCode(EnumMsgCode.ECOM0005.stringValue());
            clientRsp.setReason(messageSource.getMessage(EnumMsgCode.ECOM0005.stringValue(), null,
                    Locale.getDefault()));
        }
        return clientRsp;

    }

    /**
     * 获取修改历史列表
     *
     * @param clientRequest
     * @return
     * @throws Exception
     */
    public StationLogListResponse stationlogquery(ClientRequest clientRequest) {
        log.info("stationlogquery execute==============================");
        String userName = clientRequest.getUserName();
        String nodeCode = clientRequest.getNodeCode();
        String nodeName = clientRequest.getNodeName();

        StationLogListResponse stationLogListRsp = new StationLogListResponse();
        PageParameter page = new PageParameter(clientRequest.getPage(), clientRequest.getPageSize());
        List<BsNodeLog> logList = bsNodeLogService.findBsNodeLogPage(userName, nodeCode, nodeName, page);
        stationLogListRsp.setCurrentPage(page.getCurrentPage());
        stationLogListRsp.setTotalCount(page.getTotalCount());
        stationLogListRsp.setTotalPage(page.getTotalPage());
        stationLogListRsp.setPageSize(page.getPageSize());
        stationLogListRsp.setStationLogList(logList);
        return stationLogListRsp;
    }

}
