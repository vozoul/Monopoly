package fr.srault.game.console;

import fr.srault.game.monopoly.Monopoly;
import fr.srault.game.monopoly.player.HumanPlayer;
import fr.srault.game.monopoly.player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class ClientConsole {

    private static String CREATE_PLAYER = "1";
    private static String BEGIN_GAME = "2";
    private static String QUIT_GAME = "3";
    private static String Log = "";
    private static ArrayList<Player> playerList = new ArrayList<>();

    public static void main(String[] args){
        System.out.println("/*======================= MONOPOLY ========================*\\");
        System.out.println(" *                                  - DEVELOPPER PAR VINCE.*");
        Monopoly game = new Monopoly();
        Scanner scan = new Scanner(System.in);
        String menuChoice = "";

        do{
            if(Log != ""){
                System.out.println(Log);
            }
            Log = "";
            menuChoice = displayMenu(scan);
            if(menuChoice.equals(CREATE_PLAYER)){
                createPlayer(scan);
            }else if(menuChoice.equals(BEGIN_GAME)){
                if(playerList.size()<2) {
                    Log = " === Pas suffisemant de joueurs !! ===\n === Veuillez inscrire d'autres joueurs ===\n";
                }else if (playerList.size()>8){
                    Log = " === Trop de joueurs veuillez faire un choix ===\n";
                    choosePlayers(playerList, scan);
                }else {
                    Log = "";
                    launchGame(game, playerList, scan);
                }
            }
        }while(!menuChoice.equals(QUIT_GAME));
        scan.close();
        System.out.println("Au revoir !");
    }

    private static void createPlayer(Scanner scan){
        System.out.println("Nom du joueur à ajouter");
        String newPlayer = scan.nextLine();
        playerList.add(new HumanPlayer(newPlayer));
    }

    private static void choosePlayers(ArrayList<Player> players, Scanner scan){
        int joueur = 1;
        System.out.println("    CHOIX DES JOUEURS");
        for(Player player:players){
            System.out.println(joueur + " - " + player.getName());
            joueur++;
        }
    }

    private static void launchGame(Monopoly game, ArrayList<Player> players, Scanner scan){

    }

    private static String displayMenu(Scanner scan){
        System.out.println("    QUE VOULEZ VOUS FAIRE ?\n");
        System.out.println("    1 - Inscrire les joueurs");
        System.out.println("    2 - Commencer la partie");
        System.out.println("    3 - Quitter le jeu");
        System.out.println("\\*=========================================================*/");
        if(scan.hasNext()) {
            String choice = scan.nextLine();
            return choice;
        }
        return "";
    }
}
