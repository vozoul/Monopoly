package fr.srault.game.monopoly.player;

/**
 * Settings and Abilities of players
 */
public interface Player {

    /**
     * Called by game state.
     * @return player name
     */
    public String getName();

    /**
     * Set in the client to set a new player.
     * @param name String
     */
    public void setName(String name);

    /**
     * Called current the turn to buy something or pay bills
     * @return fund of current player
     */
    public int getFund();

    /**
     * Add fund to the player funds
     * @param add money to player funds
     */
    public void addFund(int add);

    /**
     * remove fund when player pay a bill or buy something
     * @param remove money from player funds
     */
    public void removeFund(int remove);

    /**
     * Move the player above the board
     * @param value of the displacement
     * @param isDouble get the dice result to do actions
     */
    public void move(int value, boolean isDouble);

    /**
     * when a player do a double he do something esle
     * @return if he done one or not
     */
    public boolean doDouble();

    /**
     * it's used to move a player out of jail
     * @return if the player can play or not
     */
    public boolean canPlay();
}
