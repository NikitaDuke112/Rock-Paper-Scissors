package com.game.rps.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Player {
    @NonNull
    String name;
    Hand_Signs hand;
    Amount amount;
    int playGame;
    int winGame;

    public void increasePlayGame() {
        playGame++;
    }

    public void increaseWinGame() {
        winGame++;
    }

    @Override
    public String toString() {
        return "Player name: " + name + ", play game: " + playGame + ", win game: " + winGame + ", amount: " + amount;
    }
}
