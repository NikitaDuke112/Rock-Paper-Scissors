package com.game.rps.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Amount {
    int amount;
    Currency currency;

    public Amount(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }
}
