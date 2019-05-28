package fr.vozoul.game.monopoly;

import fr.vozoul.game.monopoly.player.HumanPlayer;
import fr.vozoul.game.monopoly.player.Player;

public class TestMonopoly {

    public static void main(String[] args){
        Player player1 = new HumanPlayer("Vozoul");
        Player player2 = new HumanPlayer("Yamete");

        Monopoly monopolyTest =  new Monopoly(player1, player2);

        monopolyTest.start();

    }
}
