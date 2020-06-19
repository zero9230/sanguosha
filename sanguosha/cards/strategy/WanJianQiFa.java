package sanguosha.cards.strategy;

import sanguosha.cards.Color;
import sanguosha.cards.EquipType;
import sanguosha.cards.Strategy;
import sanguosha.manager.GameManager;
import sanguosha.people.Person;

import java.util.Iterator;

public class WanJianQiFa extends Strategy {

    public WanJianQiFa(Color color, int number) {
        super(color, number);
    }

    @Override
    public Object use() {
        Iterator<Person> it = GameManager.getPlayers().iterator();
        while (it.hasNext()) {
            Person p = it.next();
            if (p != getSource() && !gotWuXie(p) && !p.requestShan()
                    && !p.hasEquipment(EquipType.shield, "藤甲")) {
                p.hurt(getThisCard(), getSource(), 1);
            }
            if (p.isDead()) {
                it.remove();
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "万箭齐发";
    }
}