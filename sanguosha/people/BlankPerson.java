package sanguosha.people;

public class BlankPerson extends Person {
    public BlankPerson() {
        super(4,  "male", Nation.QUN);
    }

    public BlankPerson(int maxHP) {
        super(maxHP,  "male", Nation.QUN);
    }

    @Override
    public String toString() {
        return "白板";
    }
}