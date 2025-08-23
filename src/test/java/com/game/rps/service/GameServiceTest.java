package com.game.rps.service;

import com.game.rps.dto.Computer;
import com.game.rps.dto.GameResult;
import com.game.rps.dto.Hand_Signs;
import com.game.rps.dto.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    // may be change
    @Test
    void checkWinner() {
        GameService gameService = new GameService();
        Player player = new Player("Nikita");
        Computer computer = new Computer();

        player.setHand(Hand_Signs.ROCK); // player rock

        computer.setHand(Hand_Signs.SCISSORS);
        assertEquals(GameResult.PLAYER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.PAPER);
        assertEquals(GameResult.COMPUTER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.ROCK);
        assertEquals(GameResult.DRAW, gameService.checkWinner(player, computer));

        player.setHand(Hand_Signs.SCISSORS); // player scissors

        computer.setHand(Hand_Signs.PAPER);
        assertEquals(GameResult.PLAYER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.ROCK);
        assertEquals(GameResult.COMPUTER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.SCISSORS);
        assertEquals(GameResult.DRAW, gameService.checkWinner(player, computer));

        player.setHand(Hand_Signs.PAPER); // player paper

        computer.setHand(Hand_Signs.ROCK);
        assertEquals(GameResult.PLAYER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.SCISSORS);
        assertEquals(GameResult.COMPUTER, gameService.checkWinner(player, computer));

        computer.setHand(Hand_Signs.PAPER);
        assertEquals(GameResult.DRAW, gameService.checkWinner(player, computer));
    }
}