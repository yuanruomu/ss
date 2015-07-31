package cn.yrm.ss.api.rsp;


import cn.yrm.ss.node.domain.BsNode;

public class StationInfoResponse extends ClientResponse {

    private static final long serialVersionUID = -978668287388001186L;

    private BsNode stationInfo = null;

    public BsNode getStationInfo() {
        return stationInfo;
    }

    public void setStationInfo(BsNode stationInfo) {
        this.stationInfo = stationInfo;
    }
}
