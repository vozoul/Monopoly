package fr.srault.game.monopoly.board;

import fr.srault.game.monopoly.player.Player;

public interface CaseBoard {

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
     * Action on player passed on case during the displacement
     * @param player
     */
    public void moveOn(Player player);

    /**
     * Action on player when he is on case
     * @param player
     */
    public void stayOn(Player player);

}
