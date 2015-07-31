package cn.yrm.ss.api.rsp;

import cn.yrm.ss.node.domain.BsNodeLog;

import java.util.List;


public class StationLogListResponse extends ListResponse {

    private static final long serialVersionUID = -2279653908647423500L;

    private List<BsNodeLog> stationLogList;

    public List<BsNodeLog> getStationLogList() {
        return stationLogList;
    }

    public void setStationLogList(List<BsNodeLog> stationLogList) {
        this.stationLogList = stationLogList;
    }

}
