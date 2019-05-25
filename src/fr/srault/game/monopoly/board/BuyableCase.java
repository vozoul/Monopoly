package fr.srault.game.monopoly.board;

import fr.srault.game.monopoly.player.Player;

public interface BuyableCase extends CaseBoard {

    /**
     * Action on player during a trade
     * @param player
     */
    public void buy(Player player);

    /**
     * Get the Owner of the property
     * @return
     */
    public Player getOwner();

    /**
     * set the owner to player on the property
     * @param player
     */
    public void setOwner(Player player);

    /**
     * price
     * @return the cost of case
     */
    public int getCost();

    /**
     * Rent (loyer)
     * @return the rent
     */
    public int getRent();

    /**
     * mortgage (hypotheque)
     * @return the mortgage
     */
    public int getMortgage();

    /**
     * get if the player is the owner to do action
     * @param player
     * @return true | false
     */
    public boolean isOwner(Player player);

}
