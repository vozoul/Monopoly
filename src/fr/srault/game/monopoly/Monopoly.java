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
    }

    public void initBoard() {
        //prevoir un json pour la map
        //ahout de chaque cases et des gropes
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
        board.addCaseBoard(new BuildingCaseImpl("Bvd Belleville", 60, 2, 10,30, 90, 160,250, 30,violet, 50));
        board.addCaseBoard(new CaseBoardImpl("Caisse de caumunauté"));
        board.addCaseBoard(new BuildingCaseImpl("Rue lecourbe", 60, 4,20,60,180,320,450, 30,violet, 50));
        board.addCaseBoard(new CaseBoardImpl("Taxes"));
        board.addCaseBoard(new BuyableCaseImpl("Gare Monparnasse", 200, 2, 100,gare));
        board.addCaseBoard(new BuildingCaseImpl("Rue de Vaugirard", 100, 6,30,90,270,400,550, 50, bleu, 50));
        board.addCaseBoard(new CaseBoardImpl("Chance"));
        board.addCaseBoard(new BuildingCaseImpl("Rue de Courcelles", 100, 6,30,90,270,400,550, 50, bleu, 50));
        board.addCaseBoard(new BuildingCaseImpl("Av de la Republique", 120, 8,40,100,300,450,600, 60, bleu, 50));
        board.addCaseBoard(new CaseBoardImpl("Prison"));
        board.addCaseBoard(new BuildingCaseImpl("Bvd de la villette", 140, 10,50,150,450,625,750, 70, orange, 100));
        board.addCaseBoard(new BuyableCaseImpl("Compagnie de distribution d'electricité",150, 0, 75, compagnie));
        board.addCaseBoard(new BuildingCaseImpl("Av de Neuilly", 140, 10,50,150,450,625,750, 70, orange, 100));
        board.addCaseBoard(new BuildingCaseImpl("Rue de Paradis", 160, 12,60,180,500,700,900, 80, orange, 100));
        board.addCaseBoard(new BuyableCaseImpl("Gare de Lyon", 200, 2, 100,gare));
        board.addCaseBoard(new BuildingCaseImpl("Av de Mozart", 180, 14,70,200,550,700,900, 90, vert, 100));
        board.addCaseBoard(new CaseBoardImpl("Caisse de Communauté"));
        board.addCaseBoard(new BuildingCaseImpl("Bvd Saint Michel", 180, 14,70,200,550,700,900, 90, vert, 100));
        board.addCaseBoard(new BuildingCaseImpl("Place Pigalle", 200, 16,80,220,600,800,950, 100, vert, 100));
        board.addCaseBoard(new CaseBoardImpl("Park Gratuit"));
        board.addCaseBoard(new BuildingCaseImpl("Av Matignon", 220, 18,90,250,700,875,1050, 110, rouge, 150));
        board.addCaseBoard(new CaseBoardImpl("Chance"));
        board.addCaseBoard(new BuildingCaseImpl("Bvd MalesHerbes", 220, 18,90,250,700,875,1050, 110, rouge, 150));
        board.addCaseBoard(new BuildingCaseImpl("Av Henri-Martin", 240, 20,100,300,750,925,1100, 120, rouge, 150));
        board.addCaseBoard(new BuyableCaseImpl("Gare du Nord", 200, 2, 100,gare));
        board.addCaseBoard(new BuildingCaseImpl("Fb Saint Honoré", 260, 22,110,330,800,975,1150, 130, jaune, 150));
        board.addCaseBoard(new BuildingCaseImpl("Place de la Bourse", 260, 22,110,330,800,975,1150, 130, jaune, 150));
        board.addCaseBoard(new BuyableCaseImpl("Compagnie de distribution des eaux",150, 0, 75, compagnie));
        board.addCaseBoard(new BuildingCaseImpl("Rue lafayette", 280, 24,120,360,850,1025,1200, 140, jaune, 150));
        board.addCaseBoard(new CaseBoardImpl("Aller en Prison"));
        board.addCaseBoard(new BuildingCaseImpl("Av de Breteuil", 300, 26,130,390,900,1100,1275, 150, rose, 200));
        board.addCaseBoard(new BuildingCaseImpl("Av Foch", 300, 26,130,390,900,1100,1275, 150, rose, 200));
        board.addCaseBoard(new CaseBoardImpl("Caisse de Communauté"));
        board.addCaseBoard(new BuildingCaseImpl("Bvd des Capucines", 320, 28,150,450,1000,1200,1400, 160, rose, 200));
        board.addCaseBoard(new BuyableCaseImpl("Gare Saint-Lazarre", 200, 2, 100,gare));
        board.addCaseBoard(new CaseBoardImpl("Chance"));
        board.addCaseBoard(new BuildingCaseImpl("Av des Champs Elysées", 350, 35,175,500,1100,1300,1500, 175, marine, 200));
        board.addCaseBoard(new CaseBoardImpl("Caisse de Communauté"));
        board.addCaseBoard(new BuildingCaseImpl("Rue de la Paix", 400, 50,200,600,1400,1700,2000, 200, marine, 200));
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

    public void doTurn(){

    }
}
