package fr.srault.game.monopoly;

import fr.srault.game.monopoly.player.HumanPlayer;
import fr.srault.game.monopoly.player.Player;

public class TestMonopoly {

    public static void main(String[] args){
        Player player1 = new HumanPlayer("Vozoul");
        Player player2 = new HumanPlayer("Yamete");

        Monopoly monopolyTest =  new Monopoly(player1, player2);

        monopolyTest.start();

    }
}
