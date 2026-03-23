public class Data {

    public static final int SINGLE_TYPE = 1;
    public static final int DUAL_TYPE = 2;

    private String name;
    private int typeCount;
    private int hp;
    private int attack;
    private int defense;

    public Data(String name, int typeCount, int hp, int attack, int defense) {
        if (typeCount != 1 && typeCount != 2) {
            throw new IllegalArgumentException("typeCount must be 1 or 2");
        }

        this.name = name;
        this.typeCount = typeCount;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getTypeCount() {
        return typeCount;
    }

    public int getHP() {
        return hp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public double getStrength() {
        return (hp + attack + defense) / 3.0;
    }

    public String getTypeLabel() {
        return (typeCount == SINGLE_TYPE) ? "Single-type" : "Dual-type";
    }

    @Override
    public String toString() {
        return String.format(
            "%s | %s | HP: %d | Attack: %d | Defense: %d",
            name, getTypeLabel(), hp, attack, defense
        );
    }
}