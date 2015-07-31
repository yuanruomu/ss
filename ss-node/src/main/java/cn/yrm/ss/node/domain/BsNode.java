package cn.yrm.ss.node.domain;

import java.io.Serializable;

public class BsNode implements Serializable {

    private static final long serialVersionUID = 1700693898314683224L;

    private Integer nodeId;
    private String nodeCode;
    private String nodeName;
    private Double longitude;
    private Double latitude;
    private Integer ccchChannelNum;
    private Integer gprsChannelNum;
    private Integer workPower;
    private Boolean isEgprsSupport;
    private Boolean isTdCover;
    private String optimizeArea;
    private String optimizeAreaUser;
    private Boolean isIndoorCover;
    private String coverScene;
    private String autoRoadTestArea;
    private String belongGridNo;
    private String aEomsAccount;
    private String bEomsAccount;
    private String roleGroup;
    private String subroleId;
    private String coverHighway;

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getCcchChannelNum() {
        return ccchChannelNum;
    }

    public void setCcchChannelNum(Integer ccchChannelNum) {
        this.ccchChannelNum = ccchChannelNum;
    }

    public Integer getGprsChannelNum() {
        return gprsChannelNum;
    }

    public void setGprsChannelNum(Integer gprsChannelNum) {
        this.gprsChannelNum = gprsChannelNum;
    }

    public Integer getWorkPower() {
        return workPower;
    }

    public void setWorkPower(Integer workPower) {
        this.workPower = workPower;
    }

    public Boolean getIsEgprsSupport() {
        return isEgprsSupport;
    }

    public void setIsEgprsSupport(Boolean isEgprsSupport) {
        this.isEgprsSupport = isEgprsSupport;
    }

    public Boolean getIsTdCover() {
        return isTdCover;
    }

    public void setIsTdCover(Boolean isTdCover) {
        this.isTdCover = isTdCover;
    }

    public String getOptimizeArea() {
        return optimizeArea;
    }

    public void setOptimizeArea(String optimizeArea) {
        this.optimizeArea = optimizeArea;
    }

    public String getOptimizeAreaUser() {
        return optimizeAreaUser;
    }

    public void setOptimizeAreaUser(String optimizeAreaUser) {
        this.optimizeAreaUser = optimizeAreaUser;
    }

    public Boolean getIsIndoorCover() {
        return isIndoorCover;
    }

    public void setIsIndoorCover(Boolean isIndoorCover) {
        this.isIndoorCover = isIndoorCover;
    }

    public String getCoverScene() {
        return coverScene;
    }

    public void setCoverScene(String coverScene) {
        this.coverScene = coverScene;
    }

    public String getAutoRoadTestArea() {
        return autoRoadTestArea;
    }

    public void setAutoRoadTestArea(String autoRoadTestArea) {
        this.autoRoadTestArea = autoRoadTestArea;
    }

    public String getBelongGridNo() {
        return belongGridNo;
    }

    public void setBelongGridNo(String belongGridNo) {
        this.belongGridNo = belongGridNo;
    }

    public String getAEomsAccount() {
        return aEomsAccount;
    }

    public void setAEomsAccount(String aEomsAccount) {
        this.aEomsAccount = aEomsAccount;
    }

    public String getBEomsAccount() {
        return bEomsAccount;
    }

    public void setBEomsAccount(String bEomsAccount) {
        this.bEomsAccount = bEomsAccount;
    }

    public String getRoleGroup() {
        return roleGroup;
    }

    public void setRoleGroup(String roleGroup) {
        this.roleGroup = roleGroup;
    }

    public String getSubroleId() {
        return subroleId;
    }

    public void setSubroleId(String subroleId) {
        this.subroleId = subroleId;
    }

    public String getCoverHighway() {
        return coverHighway;
    }

    public void setCoverHighway(String coverHighway) {
        this.coverHighway = coverHighway;
    }

    public String getCoverRailway() {
        return coverRailway;
    }

    public void setCoverRailway(String coverRailway) {
        this.coverRailway = coverRailway;
    }

    public String getCoverNationalRoad() {
        return coverNationalRoad;
    }

    public void setCoverNationalRoad(String coverNationalRoad) {
        this.coverNationalRoad = coverNationalRoad;
    }

    public String getCoverScenic() {
        return coverScenic;
    }

    public void setCoverScenic(String coverScenic) {
        this.coverScenic = coverScenic;
    }

    public String getCoverCollege() {
        return coverCollege;
    }

    public void setCoverCollege(String coverCollege) {
        this.coverCollege = coverCollege;
    }

    public String getVillageCoverType() {
        return villageCoverType;
    }

    public void setVillageCoverType(String villageCoverType) {
        this.villageCoverType = villageCoverType;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public Boolean getIsVipVillage() {
        return isVipVillage;
    }

    public void setIsVipVillage(Boolean isVipVillage) {
        this.isVipVillage = isVipVillage;
    }

    public Boolean getIsVillageInBuild() {
        return isVillageInBuild;
    }

    public void setIsVillageInBuild(Boolean isVillageInBuild) {
        this.isVillageInBuild = isVillageInBuild;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    private String coverRailway;
    private String coverNationalRoad;
    private String coverScenic;
    private String coverCollege;
    private String villageCoverType;
    private String villageName;;
    private Boolean isVipVillage;
    private Boolean isVillageInBuild;
    private String serviceStatus;
    private Long createAt;
    private Long updateAt;

}
