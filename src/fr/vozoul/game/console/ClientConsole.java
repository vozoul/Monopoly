package fr.vozoul.game.console;

import fr.vozoul.game.database.MysqlDatabase;
import fr.vozoul.game.monopoly.Monopoly;
import fr.vozoul.game.monopoly.player.HumanPlayer;
import fr.vozoul.game.monopoly.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientConsole {

    private static String CREATE_PLAYER = "1";
    private static String BEGIN_GAME = "2";
    private static String LIST_PLAYER = "3";
    private static String QUIT_GAME = "4";
    private static String TEST_Connection = "5";
    private static String Log = "";
    private static ArrayList<Player> playerList = new ArrayList<>();
    private static ArrayList<Player> playingPlayerList = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("/*======================= MONOPOLY ========================*\\");
        System.out.println(" *                                  - DEVELOPPER PAR VINCE.*");
        Monopoly game = new Monopoly();
        Scanner scan = new Scanner(System.in);
        String menuChoice = "";

        do {
            System.out.println(Log);
            menuChoice = displayMenu(scan);
            if (menuChoice.equals(CREATE_PLAYER)) {
                createPlayer(scan);
            } else if (menuChoice.equals(BEGIN_GAME)) {
                if (playerList.size() < 2) {
                    Log = " === Pas suffisemant de joueurs !! ===\n === Veuillez inscrire d'autres joueurs ===\n";
                } else if (playerList.size() > 8) {
                    Log = " === Trop de joueurs veuillez faire un choix ===\n";
                    choosePlayers(playerList, scan);
                } else if (menuChoice.equals(TEST_Connection)) {
                    MysqlDatabase db = new MysqlDatabase();
                    db.tryToConnect();
                } else {
                    Log = "";
                    launchGame(game, playerList, scan);
                }
            } else if (menuChoice.equals(LIST_PLAYER)) {
                System.out.println(listingPlayers(playerList));
            }
            Log = "";
        } while (!menuChoice.equals(QUIT_GAME));
        scan.close();
        System.out.println("Au revoir !");
    }

    private static void createPlayer(Scanner scan) {
        System.out.println("Nom du joueur à ajouter");
        String newPlayer = scan.nextLine();
        playerList.add(new HumanPlayer(newPlayer));
    }

    private static void choosePlayers(ArrayList<Player> players, Scanner scan) {
        System.out.println("    CHOIX DES JOUEURS");
        listingPlayers(players);
        System.out.println("Combien voulez vou en choisir");
        int numberChoosen = scan.nextInt();
        for (int i = 0; i < numberChoosen; i++) {
            System.out.println("Indiquer le numero du joueur");
            int choising = scan.nextInt();
            playingPlayerList.add(playerList.get(choising));
        }
        playerList = playingPlayerList;
    }

    private static void launchGame(Monopoly game, ArrayList<Player> players, Scanner scan) {
        //listingPlayers(players);
    }

    private static String displayMenu(Scanner scan) {
        System.out.println(Log);
        System.out.println("    QUE VOULEZ VOUS FAIRE ?\n");
        System.out.println("    1 - Ajouter un joueurs");
        System.out.println("    2 - Commencer la partie");
        System.out.println("    3 - Lister les joueurs");
        System.out.println("    4 - Quitter le jeu");
        System.out.println("\\*=========================================================*/");
        if (scan.hasNext()) {
            String choice = scan.nextLine();
            return choice;
        }
        return "";
    }

    public static String listingPlayers(ArrayList<Player> players) {
        if (players.size() > 0) {
            int joueur = 1;
            for (Player player : players) {
                Log += "\n" + joueur + " - " + player.getName() + " avec : $" + player.getFund();
                joueur++;
            }
            return Log;
        }
        return Log = "\nAuncun joueurs inscrits pour la partie.\n";
    }
}
