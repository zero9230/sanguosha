package sanguosha.people.shu;

import sanguosha.cards.Card;
import sanguosha.cards.basic.Sha;
import sanguosha.manager.GameManager;

import sanguosha.people.Identity;
import sanguosha.people.Nation;
import sanguosha.people.Person;
import sanguosha.skills.KingSkill;
import sanguosha.skills.Skill;

import java.util.ArrayList;

public class LiuBei extends Person {
    private int rendeCount;
    private boolean hasRecovered;

    public LiuBei() {
        super(4, Nation.SHU);
    }

    @Override
    public void beginPhase() {
        rendeCount = 0;
        hasRecovered = false;
    }

    @Skill("仁德")
    public void renDe() {
        Person p = selectPlayer();
        if (p == null) {
            return;
        }
        ArrayList<Card> cards = chooseManyFromProvided(0, getCards());
        if (cards == null || cards.isEmpty()) {
            return;
        }
        println(this + " gives " + cards.size() + " sanguosha.cards to " + p);
        p.addCard(cards);
        rendeCount += cards.size();
        if (!hasRecovered && rendeCount >= 2) {
            recover(1);
            hasRecovered = true;
        }
    }

    @KingSkill("激将")
    public Sha jiJiang() {
        ArrayList<Person> shuPeople = GameManager.peoplefromNation(Nation.SHU);
        shuPeople.remove(this);
        if (shuPeople.isEmpty()) {
            println("no 蜀 sanguosha.people available");
            return null;
        }
        for (Person p : shuPeople) {
            Sha sha = p.requestSha();
            if (sha != null) {
                println(p + " answers 激将 from " + this);
                return sha;
            }
        }
        return null;
    }

    @Override
    public boolean skillSha() {
        if (getIdentity() == Identity.KING && launchSkill("激将")) {
            return jiJiang() != null;
        }
        return false;
    }

    @Override
    public boolean useSkillInUsePhase(String order) {
        if (order.equals("仁德")) {
            renDe();
            return true;
        }
        else if (order.equals("激将") && getIdentity() == Identity.KING) {
            Sha sha = jiJiang();
            useCard(sha);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "刘备";
    }
}