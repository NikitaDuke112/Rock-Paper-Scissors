package com.game.rps.service;

import com.game.rps.dto.Amount;
import com.game.rps.dto.Currency;
import com.game.rps.exceptions.NoCurrencyException;
import com.game.rps.exceptions.NotEnoughtMoney;

import java.util.Scanner;

public class BillingService {
    public Amount createAmount(Scanner sc) {
        int amount;
        Currency currency;

        System.out.print("Write your amount: ");
        amount = sc.nextInt();
        sc.nextLine();

        System.out.println("""
                1 - UAH \
                
                2 - USD \
                
                3 - EUR""");
        System.out.print("Write your currency : ");
        switch (sc.nextInt()) {
            case 1:
                currency = Currency.UAH;
                break;
            case 2:
                currency = Currency.USD;
                break;
            case 3:
                currency = Currency.EUR;
                break;
            default:
                    throw new NoCurrencyException("There is no such currency");
        }
        sc.nextLine();

        return new Amount(amount, currency);
    }

    public int placeBet(Amount amount, Scanner sc) {
        if (amount.getAmount() <= 0) {
            throw new NotEnoughtMoney("You don't have amount, game over!");
        }

        int bet;

        System.out.println("You have " + amount);
        System.out.println("You can bet a maximum of " + amount.getAmount() + ", place a bet: ");
        bet = sc.nextInt();
        sc.nextLine();

        if (bet > amount.getAmount() || bet <= 0) {
            throw new NotEnoughtMoney("You don't have amount");
        }

        return bet;
    }

    public void increaseAmount(Amount amount, int value) {
        amount.setAmount(amount.getAmount() + value);
    }

    public void decreaseAmount(Amount amount, int value) {
        amount.setAmount(amount.getAmount() - value);
    }
}
