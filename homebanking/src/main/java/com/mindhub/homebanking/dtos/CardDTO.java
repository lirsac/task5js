package com.mindhub.homebanking.dtos;

import com.mindhub.homebanking.models.Card;

import java.time.LocalDate;

public class CardDTO {
    private Long id;
    private String number;
    private String securityCode;
    private LocalDate validFrom;
    private LocalDate validTo;
    private String cardholderName;
    private String type;
    private String color;

    public CardDTO() {
    }

    public CardDTO(Card card) {
        this.id = card.getId();
        this.number = card.getNumber();
        this.securityCode = card.getSecurityCode();
        this.validFrom = card.getValidFrom();
        this.validTo = card.getValidTo();
        this.cardholderName = card.getCardholderName();
        this.type = card.getType().name();
        this.color = card.getColor().name();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
