package fr.srault.game.dice;

public class SimpleDice {

    private int dice = 0;

    public SimpleDice(){
        launch();
    }

    public void launch(){
        // TODO
        dice = 1 + (int) (Math.random()*(6-1))+1;
    }

    public int getValue() {
        return dice;
    }


}