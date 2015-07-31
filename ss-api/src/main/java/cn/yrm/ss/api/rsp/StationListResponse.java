package cn.yrm.ss.api.rsp;

import cn.yrm.ss.node.domain.BsNode;

import java.util.List;


public class StationListResponse extends ListResponse {

    private static final long serialVersionUID = -640055845806561802L;

    private List<BsNode> stationList;

    public List<BsNode> getStationList() {
        return stationList;
    }

    public void setStationList(List<BsNode> stationList) {
        this.stationList = stationList;
    }

}
