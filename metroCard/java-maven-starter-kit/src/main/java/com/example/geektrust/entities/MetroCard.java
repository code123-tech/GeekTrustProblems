package com.example.geektrust.entities;

public class MetroCard extends BaseEntity{
    private Long balance;
    private String cardId;

    public Long getBalance() {
        return balance;
    }

    public MetroCard(String id,Long balance, String cardId) {
        this.id=id;
        this.balance = balance;
        this.cardId = cardId;
    }
    public MetroCard(Long balance, String cardId) {
        this.balance = balance;
        this.cardId = cardId;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getCardId() {
        return cardId;
    }
}
