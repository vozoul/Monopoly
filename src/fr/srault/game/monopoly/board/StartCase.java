package fr.srault.game.monopoly.board;

import fr.srault.game.monopoly.player.Player;

public class StartCase extends CaseBoardImpl {

    public StartCase() {
        super("START");
    }

    @Override
    public void moveOn(Player player) {
        super.moveOn(player);
    }

    @Override
    public void stayOn(Player player) {
        super.stayOn(player);
    }
}
