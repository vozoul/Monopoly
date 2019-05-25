package fr.srault.game.monopoly;

import fr.srault.game.dice.DoubleDice;
import fr.srault.game.monopoly.board.*;
import fr.srault.game.monopoly.player.Player;

import java.util.ArrayList;
import java.util.List;

public class Monopoly {

    private List<Player> playerList;
    private Player currentPlayer;

    private Board board;

    public Monopoly (Player ...players ) {
        playerList = new ArrayList<>();
        for (Player player : players) {
            if(!playerList.contains(player)) {
                playerList.add(player);
            }
        }

        init();
    }

    public void init() {
        initBoard();
        // todo
        // initPlayers();
    }

    public void initBoard() {
        board = new Board();
        // initilaisation des groupes
        Group violet = new Group();
        Group bleu = new Group();
        Group orange = new Group();
        Group vert = new Group();
        Group rouge = new Group();
        Group jaune = new Group();
        Group rose = new Group();
        Group marine = new Group();
        Group gare = new Group();
        Group compagnie = new Group();

        // ajout des cases
        board.addCaseBoard(new StartCase());
        board.addCaseBoard(new BuildingCaseImpl("Bvd Belleville", 60, 2, 30,violet, 50));
        board.addCaseBoard(new BuildingCaseImpl("Bvd Belleville", 60, 2, 30,violet, 50));
        board.addCaseBoard(new BuyableCaseImpl("Gare du nord", 60, 2, 30,gare));


        //...

    }

    public void start(){
        DoubleDice doubleDice = new DoubleDice();
        do {
            nextPlayer();
            doubleDice.launch();
            currentPlayer.move(doubleDice.getValue(), doubleDice.isDouble());
        }while (!hasWinner());

    }

    private void nextPlayer() {
        if (!hasAvailablePlayer()) {
            currentPlayer = null;
            return;
        }
        if (currentPlayer == null) {
            currentPlayer = playerList.get(0);
        } else {
            if (!currentPlayer.doDouble()) {
                int currentIndexPlayer = playerList.indexOf(currentPlayer);
                int newIndexPlayer = currentIndexPlayer + 1;
                if (newIndexPlayer == playerList.size()) {
                    newIndexPlayer = 0;
                }
                currentPlayer = playerList.get(newIndexPlayer);
            }
        }
        if (!currentPlayer.canPlay()) {
            nextPlayer();
        }
    }

    private boolean hasWinner() {
        // TODO
        return false;
    }

    private boolean hasAvailablePlayer() {
        for (Player player : playerList) {
            if (player.canPlay()) {
                return true;
            }
        }
        return false;
    }


}
