package com.example.mockTest.Model;

public class RequestDTO {
    private String rqUID;
    private String clientId;
    private String account;
    private String openDate;
    private String closeDate;

    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getRqUID() {
        return rqUID;
    }

    public String getAccount() {
        return account;
    }

    public String getOpenDate() {
        return openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public String getClientId() {
        return clientId;
    }
}
