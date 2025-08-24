package com.game.rps.service;

import com.game.rps.dto.GameResult;
import com.game.rps.dto.Hand_Signs;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {
    @ParameterizedTest
    @MethodSource("points")
    void checkWinnerHand_Signs(Hand_Signs player, Hand_Signs computer, GameResult expected) {
        GameService gs = new GameService();
        assertEquals(expected, gs.checkWinner(player, computer));
    }

    private static Stream<Arguments> points() {
        return Stream.of(
                Arguments.of(Hand_Signs.ROCK, Hand_Signs.ROCK, GameResult.DRAW),
                Arguments.of(Hand_Signs.ROCK, Hand_Signs.SCISSORS, GameResult.PLAYER),
                Arguments.of(Hand_Signs.ROCK, Hand_Signs.PAPER, GameResult.COMPUTER),
                Arguments.of(Hand_Signs.SCISSORS, Hand_Signs.ROCK, GameResult.COMPUTER),
                Arguments.of(Hand_Signs.SCISSORS, Hand_Signs.SCISSORS, GameResult.DRAW),
                Arguments.of(Hand_Signs.SCISSORS, Hand_Signs.PAPER, GameResult.PLAYER),
                Arguments.of(Hand_Signs.PAPER, Hand_Signs.ROCK, GameResult.PLAYER),
                Arguments.of(Hand_Signs.PAPER, Hand_Signs.SCISSORS, GameResult.COMPUTER),
                Arguments.of(Hand_Signs.PAPER, Hand_Signs.PAPER, GameResult.DRAW)
        );
    }
}