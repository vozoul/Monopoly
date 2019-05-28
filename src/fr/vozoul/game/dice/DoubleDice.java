package fr.vozoul.game.dice;

public class DoubleDice {

    private int dice1 = 0;
    private int dice2 = 0;

    public DoubleDice(){
        launch();
    }

    public void launch(){
        dice1 = 1 + (int) (Math.random()*(6-1))+1;
        dice2 = 1 + (int) (Math.random()*(6-1))+1;
    }

    public boolean isDouble() {
        return dice1==dice2;
    }

    public int getValue() {
        return dice1 + dice2;
    }
}
