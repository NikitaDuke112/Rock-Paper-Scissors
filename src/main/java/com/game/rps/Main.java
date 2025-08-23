package com.game.rps;

import com.game.rps.dto.Computer;
import com.game.rps.dto.GameResult;
import com.game.rps.dto.Player;
import com.game.rps.service.BillingService;
import com.game.rps.service.GameService;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameService gameService = new GameService();
        BillingService billingService = new BillingService();
        GameResult gameResult;
        Player player;
        Computer computer = new Computer();
        int games;
        int bet;

        System.out.println("Welcome to Rock Scissors Paper!");

        System.out.print("Write your name: ");
        player = new Player(sc.nextLine());
        player.setAmount(billingService.createAmount(sc));

        System.out.print("How much game you want to play: ");
        games = sc.nextInt();
        sc.nextLine();

        do {
            System.out.println("=============>>>>");
            bet = billingService.placeBet(player.getAmount(), sc); // bet
            player.setHand(gameService.changeHand(sc)); // player hand
            computer.generateHandSign(); // computer hand

            System.out.println("Player hand: " + player.getHand());
            System.out.println("Computer hand: " + computer.getHand());

            gameResult = gameService.checkWinner(player, computer);

            if (gameResult.equals(GameResult.PLAYER)) {
                player.increaseWinGame();
                billingService.increaseAmount(player.getAmount(), bet);
                System.out.println(player.getName() + " won!");
            }
            else if (gameResult.equals(GameResult.COMPUTER)) {
                System.out.println("Computer won!");
                billingService.decreaseAmount(player.getAmount(), bet);
            }
            else {
                System.out.println("Draw!");
            }

            player.increasePlayGame();
            games--;
        } while (games > 0 && nextGame(sc));
        System.out.println("=============>>>>");
        System.out.println(player);
        System.out.println("GAME OVER!");
    }

    private static boolean nextGame(@NotNull Scanner sc) {
        System.out.println("Play next game? [Y/N]");

        return sc.nextLine().equalsIgnoreCase("Y");
    }
}
