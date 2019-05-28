package fr.vozoul.game.monopoly.board;

import fr.vozoul.game.monopoly.player.Player;

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


    //a deplacer sur gameSatate ("Monopoly")
    @Override
    public void buy(Player player) {
        // todo
        //si la propriete est libre
            //si le joueur peut acheter
                //est-ce qu'il achete
        if(!isOwner(player)){
            if(canBuy(player)) {
                //avant de setOwner payBill(Player player)
                setOwner(player);
            }
        }
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

    private boolean canBuy(Player player){
        return player.getFund() >= getCost();
    }

    @Override
    public int getMortgage() {
        return mortGage;
    }

    @Override
    public void doMortGage(Player Owner) {
        if(isOwner(Owner)){
            owner = null;
        }
    }
}
