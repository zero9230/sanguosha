package people.mountain;

import cards.Card;
import cards.Equipment;
import cardsheap.CardsHeap;
import manager.Utils;
import people.Nation;
import people.Person;
import skills.Skill;

import java.util.ArrayList;

public class ZhangZhaoZhangHong extends Person {
    public ZhangZhaoZhangHong() {
        super(3, Nation.WU);
    }

    @Skill("直谏")
    @Override
    public boolean useSkillInUsePhase(String order) {
        if (order.equals("直谏")) {
            println(this + " uses 直谏");
            Card c = chooseCard(getCards());
            while (c != null && !(c instanceof Equipment)) {
                println("you should choose a weapon");
                c = chooseCard(getCards());
            }
            if (c == null) {
                return true;
            }
            Person p = selectPlayer();
            while (p != null && p.hasEquipment(((Equipment) c).getEquipType(), null)) {
                println("you should choose someone without weapon");
                p = selectPlayer();
            }
            if (p == null) {
                return true;
            }
            println(p + " puts on " + c);
            p.getEquipments().put(((Equipment) c).getEquipType(), (Equipment) c);
            drawCard();
        }
        return false;
    }

    @Skill("固政")
    @Override
    public void otherPersonThrowPhase(Person p, ArrayList<Card> cards) {
        Utils.assertTrue(!cards.isEmpty(), "throw cards are empty");
        if (launchSkill("固政")) {
            Card c = chooseCard(cards);
            if (c == null) {
                return;
            }
            CardsHeap.retrieve(cards);
            p.addCard(c);
            cards.remove(c);
            addCard(cards);
        }
    }

    @Override
    public String toString() {
        return "张昭张纮";
    }
}
