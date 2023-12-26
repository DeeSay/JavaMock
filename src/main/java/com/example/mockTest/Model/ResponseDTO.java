package com.example.mockTest.Model;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class ResponseDTO {
    private String rqUID;
    private String clientId;
    private String account;
    private String currency;
    private BigDecimal balance;
    private BigDecimal maxLimit;
    public String getRqUID() {
        return rqUID;
    }

    public String getClientId() {
        return clientId;
    }

    public String getAccount() {
        return account;
    }

    public String getCurrency() {
        return currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getMaxLimit() {
        return maxLimit;
    }
    public void setRqUID(String rqUID) {
        this.rqUID = rqUID;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setMaxLimit(BigDecimal maxLimit) {
        this.maxLimit = maxLimit;
    }


}
