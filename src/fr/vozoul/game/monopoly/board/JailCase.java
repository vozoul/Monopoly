package fr.vozoul.game.monopoly.board;

import fr.vozoul.game.monopoly.player.Player;

public class JailCase extends CaseBoardImpl {

    public JailCase() {
        super("PRISON");
    }

    public boolean isPunished(Player player){
        return false;
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
