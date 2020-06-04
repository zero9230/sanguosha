package cards.equipments.shields;

import cards.Color;
import cards.equipments.Shield;

public class RenWangDun extends Shield {
    public RenWangDun(Color color, int number) {
        super(color, number);
    }

    @Override
    public Object use() {
        return null;
    }

    @Override
    public String toString() {
        return "仁王盾";
    }
}
