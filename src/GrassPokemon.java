import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GrassPokemon extends Pokemon {
    List<String> attacks = Arrays.asList("leafstorm", "Solarbeam", "leechseed", "leafBlade");

    public GrassPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, "grass");
    }

    public List<String> getAttacks() {
        return attacks;
    }

    void leafStorm(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used leaf storm");
        double damage = 50;
        typeEffectiveAttacks(enemy, damage);
    }

    void solarBeam(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used solar beam");
        double damage = 25;
        typeEffectiveAttacks(enemy, damage);
    }

    void leechSeed(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int throwTimes = rand.nextInt(5);
        System.out.println(name.getName() + " throws " + throwTimes + " leech seed");
//        double damage = 10 * throwTimes;
        double damage = 10;
        for (int i = 0; i < throwTimes; i++) {
            typeEffectiveAttacks(enemy, damage);
            damage = damage + i;
        }
    }

    void leafBlade(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int accuracyAttack = rand.nextInt(100);
        System.out.println(name.getName() + " used leaf blade");
        if (accuracyAttack > 50) {
            double damage = 70;
            typeEffectiveAttacks(enemy, damage);
        } else {
            System.out.println(name.getName() + " missed attack.");
        }
    }

    private void typeEffectiveAttacks(Pokemon enemy, double damage) {
        switch (enemy.getType()) {
            case "grass" -> {
                damage = (damage * 0.5);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "water" -> {
                damage = (damage * 0.8);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "electric" -> {
                damage = (damage * 2);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "fire" -> {
                damage = (damage * 1);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }
        }
        System.out.println("Your opponents pokemon has " + enemy.getHp() + " left.");
    }
}