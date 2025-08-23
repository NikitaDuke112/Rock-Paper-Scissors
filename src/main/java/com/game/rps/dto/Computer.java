package com.game.rps.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public class Computer {
    Hand_Signs hand;
    Random random;

    public Computer() {
        random = new Random();
    }

    public void generateHandSign() {
        hand = Hand_Signs.values()[random.nextInt(Hand_Signs.values().length)];
    }
}
