/**
 * Data Analysis Mini Project
 * 
 * This program reads a CSV of Generation 1 Pokémon stats
 * and compares single-type vs dual-type Pokémon to see
 * which group is stronger based on HP, Attack, and Defense.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class App {

    // Simple Data class inside same file
    static class Data {
        private String name;
        private int typeCount;
        private double hp;
        private double attack;
        private double defense;

        public Data(String name, int typeCount, double hp, double attack, double defense) {
            this.name = name;
            this.typeCount = typeCount;
            this.hp = hp;
            this.attack = attack;
            this.defense = defense;
        }

        public int getTypeCount() { return typeCount; }
        public double getHP() { return hp; }
        public double getAttack() { return attack; }
        public double getDefense() { return defense; }
    }

    public static void main(String[] args) {

        // 🔧 UPDATE THIS PATH
        File file = new File("data/pokemon.csv");

        Data[] dataList = new Data[200]; // enough for Gen 1
        int count = 0;

        // 📥 READ FILE
        try {
            Scanner scanner = new Scanner(file);

            // skip header
            if (scanner.hasNextLine()) {
                scanner.nextLine();
            }

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                String name = parts[1]; // Pokemon name
                // Count types: if Type 2 (parts[3]) is empty, it's single-type, else dual-type
                int typeCount = parts[3].trim().isEmpty() ? 1 : 2;
                double hp = Double.parseDouble(parts[4]);
                double attack = Double.parseDouble(parts[5]);
                double defense = Double.parseDouble(parts[6]);

                dataList[count] = new Data(name, typeCount, hp, attack, defense);
                count++;
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return;
        }

        //  ANALYSIS

        double singleHP = averageStat(dataList, count, 1, "hp");
        double singleAtk = averageStat(dataList, count, 1, "attack");
        double singleDef = averageStat(dataList, count, 1, "defense");

        double dualHP = averageStat(dataList, count, 2, "hp");
        double dualAtk = averageStat(dataList, count, 2, "attack");
        double dualDef = averageStat(dataList, count, 2, "defense");

        double singleStrength = overallStrength(singleHP, singleAtk, singleDef);
        double dualStrength = overallStrength(dualHP, dualAtk, dualDef);

        //  OUTPUT

        System.out.println("Rows loaded: " + count);
        System.out.println();

        System.out.println("Single-type averages:");
        System.out.println("HP: " + singleHP);
        System.out.println("Attack: " + singleAtk);
        System.out.println("Defense: " + singleDef);
        System.out.println("Overall Strength: " + singleStrength);
        System.out.println();

        System.out.println("Dual-type averages:");
        System.out.println("HP: " + dualHP);
        System.out.println("Attack: " + dualAtk);
        System.out.println("Defense: " + dualDef);
        System.out.println("Overall Strength: " + dualStrength);
        System.out.println();

        //  CONCLUSION

        if (dualStrength > singleStrength) {
            System.out.println("Conclusion: Dual-type Pokémon are stronger on average.");
        } else if (singleStrength > dualStrength) {
            System.out.println("Conclusion: Single-type Pokémon are stronger on average.");
        } else {
            System.out.println("Conclusion: Both types are equally strong on average.");
        }
    }

    /**
     * Calculates the average of a specific stat for a given type group.
     * typeFilter: 1 = single-type, 2 = dual-type
     */
    public static double averageStat(Data[] data, int size, int typeFilter, String stat) {
        double sum = 0;
        int count = 0;

        for (int i = 0; i < size; i++) {
            if (data[i].getTypeCount() == typeFilter) {

                if (stat.equals("hp")) {
                    sum += data[i].getHP();
                } else if (stat.equals("attack")) {
                    sum += data[i].getAttack();
                } else if (stat.equals("defense")) {
                    sum += data[i].getDefense();
                }

                count++;
            }
        }

        if (count == 0) return 0;

        return sum / count;
    }

    /**
     * Calculates overall strength as the average of HP, Attack, and Defense.
     */
    public static double overallStrength(double hp, double attack, double defense) {
        return (hp + attack + defense) / 3.0;
    }
}