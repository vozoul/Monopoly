package fr.srault.game.monopoly.board;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<CaseBoard> caseBoardList;

    public Board() {
        caseBoardList = new ArrayList<>();
    }

    public void addCaseBoard(CaseBoard caseBoard) {
        caseBoardList.add(caseBoard);
    }

    public CaseBoardImpl getCase(int index){
     return (CaseBoardImpl) caseBoardList.get(index);
    }
}
