package sanguosha.people.wind;

import sanguosha.cards.Card;
import sanguosha.cards.Color;
import sanguosha.cards.Equipment;
import sanguosha.cards.basic.Sha;
import sanguosha.people.Nation;
import sanguosha.people.Person;
import sanguosha.skills.Skill;

public class XiaHouYuan extends Person {
    private boolean useShenSu1 = false;
    private boolean useShenSu2 = false;

    public XiaHouYuan() {
        super(4, Nation.WEI);
    }

    @Skill("神速")
    public void shenSu() {
        Sha sha = new Sha(Color.NOCOLOR, 0);
        sha.setThisCard((Card) null);
        if (sha.askTarget(this)) {
            useCard(sha);
        }
    }

    @Override
    public void beginPhase() {
        useShenSu1 = false;
        if (launchSkill("神速")) {
            useShenSu1 = true;
            shenSu();
        }
    }

    @Override
    public boolean skipJudge() {
        return useShenSu1;
    }

    @Override
    public boolean skipDraw() {
        if (useShenSu1) {
            useShenSu1 = false;
        }
        return true;
    }

    @Override
    public void usePhase() {
        if (launchSkill("神速")) {
            Card c = chooseCard(getCardsAndEquipments());
            while (!(c instanceof Equipment) && c != null) {
                println("you should choose an equipment");
                c = chooseCard(getCardsAndEquipments());
            }
            if (c != null) {
                useShenSu2 = true;
                shenSu();
                useShenSu2 = false;
                return;
            }
        }
        super.usePhase();
    }

    @Override
    public int getShaDistance() {
        if (useShenSu1 || useShenSu2) {
            return 10000;
        }
        return super.getShaDistance();
    }

    @Override
    public String toString() {
        return "夏侯渊";
    }
}