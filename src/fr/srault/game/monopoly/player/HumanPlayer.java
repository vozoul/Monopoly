package fr.srault.game.monopoly.player;

import fr.srault.game.monopoly.board.Board;

public class HumanPlayer implements Player {

    private String name;
    private int doubleCount = 0;
    private int position =0;
    private int fund = 0;
    private int punish = 0;
    private Board board;

    public HumanPlayer(String name) {
        this.name = name;
        this.fund = 1500;
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
    public void move(int value, boolean isDouble) {
        if (isDouble) {
            doubleCount++;
            if (doubleCount == 3) {
                // TODO
                //goJail(player);
            }
        } else {
            doubleCount = 0;
        }

        // TODO
        //passe sur chaque cases
        int finalRoundPos = getPosition() + value;
        int index = getPosition();
        index++;
        while(index < finalRoundPos) {
            ((Board) board).getCase(index).moveOn(this);
            index++;
        }
        ((Board) board).getCase(index).stayOn(this);
    }

    public int getPosition(){
        return position;
    }

    public void setPosition(int newPos){
        this.position = newPos;
    }

    @Override
    public int getFund() {
        return fund;
    }

    @Override
    public void addFund(int add) {
        this.fund += add;
    }

    @Override
    public void removeFund(int remove) {
        this.fund -= remove;
    }

    @Override
    public boolean doDouble() {
        return doubleCount > 0;
    }

    @Override
    public boolean canPlay() {
        // TODO
        return true;
    }
}
