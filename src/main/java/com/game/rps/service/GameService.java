package com.game.rps.service;

import com.game.rps.dto.Computer;
import com.game.rps.dto.GameResult;
import com.game.rps.dto.Hand_Signs;
import com.game.rps.dto.Player;
import com.game.rps.exceptions.NoHandException;

import java.util.*;


public class GameService {
    Map<ArrayList<Hand_Signs>, GameResult> result = new HashMap<>(); // results

    public GameService() {
        initResult();
    }

    private void initResult() {
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.ROCK, Hand_Signs.ROCK)), GameResult.DRAW);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.ROCK, Hand_Signs.SCISSORS)), GameResult.PLAYER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.ROCK, Hand_Signs.PAPER)), GameResult.COMPUTER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.SCISSORS, Hand_Signs.ROCK)), GameResult.COMPUTER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.SCISSORS, Hand_Signs.SCISSORS)), GameResult.DRAW);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.SCISSORS, Hand_Signs.PAPER)), GameResult.PLAYER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.PAPER, Hand_Signs.ROCK)), GameResult.PLAYER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.PAPER, Hand_Signs.SCISSORS)), GameResult.COMPUTER);
        result.put(new ArrayList<>(Arrays.asList(Hand_Signs.PAPER, Hand_Signs.PAPER)), GameResult.DRAW);
    }

    // For comparison with other checkWinner
    @Deprecated
    public GameResult checkWinner(Player player, Computer computer) {
        if (player.getHand().equals(Hand_Signs.ROCK) && computer.getHand().equals(Hand_Signs.SCISSORS)) {
            return GameResult.PLAYER;
        } else if (player.getHand().equals(Hand_Signs.ROCK) && computer.getHand().equals(Hand_Signs.PAPER)) {
            return GameResult.COMPUTER;
        } else if (player.getHand().equals(Hand_Signs.SCISSORS) && computer.getHand().equals(Hand_Signs.ROCK)) {
            return GameResult.COMPUTER;
        } else if (player.getHand().equals(Hand_Signs.SCISSORS) && computer.getHand().equals(Hand_Signs.PAPER)) {
            return GameResult.PLAYER;
        } else if (player.getHand().equals(Hand_Signs.PAPER) && computer.getHand().equals(Hand_Signs.ROCK)) {
            return GameResult.PLAYER;
        } else if (player.getHand().equals(Hand_Signs.PAPER) && computer.getHand().equals(Hand_Signs.SCISSORS)) {
            return GameResult.COMPUTER;
        } else {
            return GameResult.DRAW;
        }
    }

    // Using
    public GameResult checkWinner(Hand_Signs player, Hand_Signs computer) {
        ArrayList<Hand_Signs> handSigns = new ArrayList<>();
        handSigns.add(player);
        handSigns.add(computer);

        return result.get(handSigns);
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
