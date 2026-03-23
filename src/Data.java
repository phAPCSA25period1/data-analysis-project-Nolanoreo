/**
 * Represents one Pokémon from the dataset.
 * 
 * Each object stores basic stats used to compare
 * single-type and dual-type Pokémon.
 */
public class Data {

    // 🧱 Attributes (from CSV columns)
    private String name;
    private int typeCount;   // 1 = single-type, 2 = dual-type
    private double hp;
    private double attack;
    private double defense;

    /**
     * Constructs a Data object with all attributes.
     * 
     * @param name the Pokémon's name
     * @param typeCount number of types (1 or 2)
     * @param hp the HP stat
     * @param attack the attack stat
     * @param defense the defense stat
     */
    public Data(String name, int typeCount, double hp, double attack, double defense) {
        this.name = name;
        this.typeCount = typeCount;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Returns the Pokémon's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns how many types the Pokémon has.
     */
    public int getTypeCount() {
        return typeCount;
    }

    /**
     * Returns the HP stat.
     */
    public double getHP() {
        return hp;
    }

    /**
     * Returns the attack stat.
     */
    public double getAttack() {
        return attack;
    }

    /**
     * Returns the defense stat.
     */
    public double getDefense() {
        return defense;
    }

    /**
     * Calculates overall strength as the average
     * of HP, Attack, and Defense.
     * 
     * @return the average stat value
     */
    public double getStrength() {
        return (hp + attack + defense) / 3.0;
    }

    /**
     * Returns a readable string of this object's data.
     */
    @Override
    public String toString() {
        return name + " | Types: " + typeCount +
               " | HP: " + hp +
               " | Attack: " + attack +
               " | Defense: " + defense;
    }
}