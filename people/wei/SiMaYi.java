package people.wei;

import cards.Card;

import cardsheap.CardsHeap;
import people.Nation;
import people.Person;
import skills.Skill;

import java.util.ArrayList;

public class SiMaYi extends Person {
    public SiMaYi() {
        super(3, Nation.WEI);
    }

    @Skill("鬼才")
    @Override
    public Card changeJudge(Card d) {
        if (launchSkill("鬼才")) {
            Card c = requestCard(null);
            if (c != null) {
                CardsHeap.retrieve(c);
                CardsHeap.discard(d);
                return c;
            }
        }
        return null;
    }

    @Skill("反馈")
    @Override
    public void gotHurt(ArrayList<Card> cards, Person p, int num) {
        if (p != null && !p.getCardsAndEquipments().isEmpty()
                && launchSkill("反馈")) {
            Card c  = chooseTargetCardsAndEquipments(p);
            p.loseCard(c, false);
            addCard(c);
        }
    }

    @Override
    public String toString() {
        return "司马懿";
    }
}
