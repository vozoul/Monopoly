package fr.srault.game.monopoly.board;

import fr.srault.game.monopoly.player.Player;

public class CaseBoardImpl implements CaseBoard {

    private String name;

    public CaseBoardImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void moveOn(Player player) {

    }

    @Override
    public void stayOn(Player player) {

    }
}
