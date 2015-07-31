package cn.yrm.ss.api.req;

public class ClientRequest {

    private String serviceName;
    private String function;
    private String token;

    private Integer page;
    private Integer pageSize;

    private String userName;
    private String password;

    /** 附近的基站查询范围(米) */
    private Integer range;

    private String nodeCode;
    private String nodeName;
    private Double longitude;
    private Double latitude;
    private String aEomsAccount;
    private String bEomsAccount;
    private Integer nodeId;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
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

    public String getaEomsAccount() {
        return aEomsAccount;
    }

    public void setaEomsAccount(String aEomsAccount) {
        this.aEomsAccount = aEomsAccount;
    }

    public String getbEomsAccount() {
        return bEomsAccount;
    }

    public void setbEomsAccount(String bEomsAccount) {
        this.bEomsAccount = bEomsAccount;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public Integer getPage() {
        return page == null || page == 0 ? 1 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize == null || pageSize == 0 ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
