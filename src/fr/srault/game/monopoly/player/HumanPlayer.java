package fr.srault.game.monopoly.player;

public class HumanPlayer implements Player {

    private String name;
    private int doubleCount = 0;
    private int fund = 0;

    public HumanPlayer(String name) {
        this.name = name;
        this.fund = 15000;
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
            }
        } else {
            doubleCount = 0;
        }

        // TODO
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
