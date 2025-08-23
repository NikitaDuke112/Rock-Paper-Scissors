package com.game.rps.exceptions;

public class NotEnoughtMoney extends RuntimeException {
    public NotEnoughtMoney(String message) {
        super(message);
    }
}
