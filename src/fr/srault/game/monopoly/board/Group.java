package fr.srault.game.monopoly.board;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private List<CaseBoard> caseBoardList = new ArrayList<>();
    //private String color;

    public Group(){}

    public void addCaseBoard(CaseBoard caseBoard) {
        caseBoardList.add(caseBoard);
    }
}
