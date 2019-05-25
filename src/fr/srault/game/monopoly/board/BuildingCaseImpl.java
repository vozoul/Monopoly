package fr.srault.game.monopoly.board;

public class BuildingCaseImpl extends BuyableCaseImpl implements BuildingCase {

    private int house = 0;
    private int houseCost = 0;
    private int rent = 0;
    private int defaultRent = 0;
    private int rent1 = 0;
    private int rent2 = 0;
    private int rent3 = 0;
    private int rent4 = 0;
    private int rent5 = 0;

    public BuildingCaseImpl(String name, int cost, int defaultRent, int rent1, int rent2, int rent3, int rent4, int rent5, int mortGage, Group family, int houseCost) {
        super(name, cost, defaultRent, mortGage, family);
        this.defaultRent = defaultRent;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.rent5 = rent5;
        this.houseCost = houseCost;
    }

        @Override
    public int getHouse() {
        return house;
    }

    @Override
    public void addHouse(int qty) {
        // TODO paiement
        this.house += qty;
    }

    @Override
    public void removeHouse(int qty) {
        // TODO paiement
        this.house -= qty;
    }

    @Override
    public int getRent() {
        switch (house){
            case 1:
                this.rent = rent1;
                break;
            case 2:
                this.rent = rent2;
                break;
            case 3:
                this.rent = rent3;
                break;
            case 4:
                this.rent = rent4;
                break;
            case 5:
                this.rent = rent5;
                break;
            default:
                this.rent = rent;
                break;

        }
        return rent;
    }
}
