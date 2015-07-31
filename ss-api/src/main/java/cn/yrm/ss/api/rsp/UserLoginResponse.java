package cn.yrm.ss.api.rsp;

public class UserLoginResponse extends ClientResponse {

    private static final long serialVersionUID = -6513667645611034253L;

    private String token = null;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
