package com.example.geektrust.common.enums;

import com.example.geektrust.common.constants.TicketPriceConstants;

public enum PassengerType {

    ADULT(TicketPriceConstants.ADULT_TICKET_PRICE),
    SENIOR_CITIZEN(TicketPriceConstants.SENIOR_CITIZEN_TICKET_PRICE),
    KID(TicketPriceConstants.KID_TICKET_PRICE);

    private Long ticketPrice;

    PassengerType(Long ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Long getTicketPrice() {
        return ticketPrice;
    }
}
