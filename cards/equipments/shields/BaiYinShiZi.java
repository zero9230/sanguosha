package cards.equipments.shields;

import cards.Color;
import cards.equipments.Shield;

public class BaiYinShiZi extends Shield {
    public BaiYinShiZi(Color color, int number) {
        super(color, number);
    }

    @Override
    public Object use() {
        return null;
    }

    @Override
    public String toString() {
        return "白银狮子";
    }
}