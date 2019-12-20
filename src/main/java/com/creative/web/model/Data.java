package com.creative.web.model;

public class Data {
    private String tokenName;
    private String tokenUuid;
    private String tokenValue;

    public Data() {
    }

    public Data(String tokenName, String tokenUuid, String tokenValue) {
        this.tokenName = tokenName;
        this.tokenUuid = tokenUuid;
        this.tokenValue = tokenValue;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public String getTokenUuid() {
        return tokenUuid;
    }

    public void setTokenUuid(String tokenUuid) {
        this.tokenUuid = tokenUuid;
    }

    public String getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(String tokenValue) {
        this.tokenValue = tokenValue;
    }
}
