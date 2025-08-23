package com.game.rps.service;

import com.game.rps.dto.Computer;
import com.game.rps.dto.GameResult;
import com.game.rps.dto.Hand_Signs;
import com.game.rps.dto.Player;
import com.game.rps.exceptions.NoHandException;

import java.util.Scanner;

public class GameService {
    public GameResult checkWinner(Player player, Computer computer) {
        if (player.getHand().equals(Hand_Signs.ROCK) && computer.getHand().equals(Hand_Signs.SCISSORS)) {
            return GameResult.PLAYER;
        }
        else if (player.getHand().equals(Hand_Signs.ROCK) && computer.getHand().equals(Hand_Signs.PAPER)) {
            return GameResult.COMPUTER;
        }
        else if (player.getHand().equals(Hand_Signs.SCISSORS) && computer.getHand().equals(Hand_Signs.ROCK)) {
            return GameResult.COMPUTER;
        }
        else if (player.getHand().equals(Hand_Signs.SCISSORS) && computer.getHand().equals(Hand_Signs.PAPER)) {
            return GameResult.PLAYER;
        }
        else if (player.getHand().equals(Hand_Signs.PAPER) && computer.getHand().equals(Hand_Signs.ROCK)) {
            return GameResult.PLAYER;
        }
        else if (player.getHand().equals(Hand_Signs.PAPER) && computer.getHand().equals(Hand_Signs.SCISSORS)) {
            return GameResult.COMPUTER;
        }
        else {
            return GameResult.DRAW;
        }
    }

    public Hand_Signs changeHand(Scanner sc) {
        System.out.println("R - rock");
        System.out.println("S - scissors");
        System.out.println("P - paper");
        System.out.println("Write your choice: ");

        return switch (sc.nextLine().toUpperCase()) {
            case "R" -> Hand_Signs.ROCK;
            case "S" -> Hand_Signs.SCISSORS;
            case "P" -> Hand_Signs.PAPER;
            default -> throw new NoHandException("Player has no hand");
        };
    }
}
