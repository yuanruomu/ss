package cn.yrm.ss.api.rsp;

import java.io.Serializable;

import org.springframework.util.StringUtils;

public class ClientResponse implements Serializable {

    private static final long serialVersionUID = 2616511332086624892L;
    
    // 默认是成功
    private boolean result = true;
    private String errorCode = "";
    private String reason = "";

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getReason() {
        return StringUtils.hasText(reason) ? reason : "";
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
