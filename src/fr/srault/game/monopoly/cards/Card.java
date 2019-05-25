package fr.srault.game.monopoly.cards;

import fr.srault.game.monopoly.player.Player;

public interface Card {

    /**
     * Answer witch card is it
     * @return the card name
     */
    public String getName();

    /**
     * Set the card name
     * @param name string
     */
    public void setName(String name);

    /**
     * Action attached to this card
     * @param player who is using card
     */
    public void doAction(Player player);

}
