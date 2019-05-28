package fr.vozoul.game.monopoly.cards;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<CardsList> cardsList = new ArrayList<>();
    //private String color;

    public Group(){}

    public void addCard(CardsList card) {
        this.cardsList.add(card);
    }
}
