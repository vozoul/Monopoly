package fr.srault.game.monopoly.board;

import fr.srault.game.monopoly.player.Player;

public class BuyableCaseImpl extends CaseBoardImpl implements BuyableCase {

    private Player owner;
    private int cost;
    protected int rent = 0;
    private int mortGage;
    private Group family;

    public BuyableCaseImpl(String name, int cost, int rent, int mortGage, Group family) {
        super(name);
        this.cost = cost;
        this.rent = rent;
        this.mortGage = mortGage;
        this.family = family;
        family.addCaseBoard(this);
    }

    @Override
    public void buy(Player player) {
        // todo
        setOwner(player);
    }

    @Override
    public Player getOwner() {
        return owner;
    }

    @Override
    public void setOwner(Player player) {
        owner = player;
    }

    @Override
    public int getCost() {
        return cost;
    }

    @Override
    public int getRent() {
        return rent;
    }

    @Override
    public boolean isOwner(Player player) {
        if(player==null){
            return false;
        }else {
            return player.equals(owner);
        }
    }

    @Override
    public int getMortgage() {
        return mortGage;
    }
}
