package sanguosha.people.wei;

import sanguosha.cards.Card;
import sanguosha.manager.GameManager;

import sanguosha.people.Identity;
import sanguosha.people.Nation;
import sanguosha.people.Person;
import sanguosha.skills.KingSkill;
import sanguosha.skills.Skill;

import java.util.ArrayList;

public class CaoCao extends Person {
    public CaoCao() {
        super(4, Nation.WEI);
    }

    @Skill("奸雄")
    @Override
    public void gotHurt(ArrayList<Card> cs, Person p, int num) {
        if (launchSkill("奸雄")) {
            if (cs != null) {
                for (Card c: cs) {
                    if (c.isNotTaken()) {
                        addCard(c);
                        c.setTaken(true);
                    }
                }
            }
        }
    }

    @KingSkill("护驾")
    @Override
    public boolean skillShan() {
        if (getIdentity() == Identity.KING && launchSkill("护驾")) {
            ArrayList<Person> weiPeople = GameManager.peoplefromNation(Nation.WEI);
            weiPeople.remove(this);
            if (weiPeople.isEmpty()) {
                println("no 魏 sanguosha.people available");
                return false;
            }
            for (Person p : weiPeople) {
                if (p.requestShan()) {
                    println(p + " answers 护驾 from " + this);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "曹操";
    }
}