package sanguosha.people.wei;

import sanguosha.people.Nation;
import sanguosha.people.Person;
import sanguosha.skills.Skill;

public class XuChu extends Person {
    private boolean isNaked = false;

    public XuChu() {
        super(4, Nation.WEI);
    }

    @Skill("裸衣")
    @Override
    public void drawPhase() {
        if (launchSkill("裸衣")) {
            println(this + " draw 1 card from sanguosha.cards heap");
            drawCard();
            isNaked = true;
            return;
        }
        super.drawPhase();
    }

    @Override
    public void endPhase() {
        isNaked = false;
    }

    @Override
    public boolean isNaked() {
        return isNaked;
    }

    @Override
    public String toString() {
        return "许褚";
    }
}