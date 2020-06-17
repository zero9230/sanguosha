package cards.strategy;

import cards.Card;
import cards.Color;
import cards.Strategy;

public class ShunShouQianYang extends Strategy {

    public ShunShouQianYang(Color color, int number) {
        super(color, number, 1);
    }

    @Override
    public Object use() {
        if (!gotWuXie(getTarget())) {
            Card c = getSource().chooseTargetAllCards(getTarget());
            getTarget().loseCard(c, false);
            getSource().addCard(c);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "顺手牵羊";
    }

    @Override
    public boolean needChooseTarget() {
        return true;
    }
}
