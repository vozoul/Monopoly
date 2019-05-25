package fr.srault.game.monopoly.cards;

import java.util.ArrayList;

public class CardsList {

    ArrayList<CommunityCard> communityCards = new ArrayList<>();
    ArrayList<LuckyCard> luckyCards = new ArrayList<>();
    private int communityCounter = 0;
    private int luckyCounter = 0;

    public CommunityCard getCommunityCards() {
        CommunityCard card = communityCards.get(communityCounter);
        communityCounter++;
        return card;
    }

    public LuckyCard getLuckyCards() {
        LuckyCard card = luckyCards.get(luckyCounter);
        luckyCounter++;
        return card;
    }
}
