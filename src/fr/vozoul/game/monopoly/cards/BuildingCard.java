package fr.vozoul.game.monopoly.cards;

public interface BuildingCard extends BuyableCard {

    /**
     * get the number of buildings are on this property
     * @return house int
     */
    public int getHouse();

    /**
     * add some houses depend the quantity attached
     * @param qty
     */
    public void addHouse(int qty);

    /**
     * remove house before a mortgage
     * @param qty
     */
    public void removeHouse(int qty);
}
