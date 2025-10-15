import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class WaterPokemon extends Pokemon {
    List<String> attacks = Arrays.asList("surf", "hydroPump", "hydroCanon", "rainDance");

    public WaterPokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, "water");
    }

    public List<String> getAttacks() {
        return attacks;
    }

    void surf(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used surf");
        double damage = 120;
        typeEffectiveAttacks(enemy, damage);
    }

    void hydroPump(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used hydro pump");
        double damage = 25;
        typeEffectiveAttacks(enemy, damage);
    }

    void hydroCanon(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int throwTimes = rand.nextInt(5);
        System.out.println(name.getName() + " throws " + throwTimes + " hydro");
//        double damage = 10 * throwTimes;
        double damage = 10;
        for (int i = 0; i < throwTimes; i++) {
            typeEffectiveAttacks(enemy, damage);
            damage = damage + i;
        }
    }

    void rainDance(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int accuracyAttack = rand.nextInt(100);
        System.out.println(name.getName() + " used rain dance");
        if (getType().equals("electric")) {
            System.out.println("Does not affect " + name.getName());
        } else if (getType().equals("grass")) {
            int i = 10;
            enemy.setHp(enemy.getHp() + i);
            System.out.println("Rain dance boosted " + name.getName() + "'s HP with 10HP");
        } else {
            double damage = 20;
            typeEffectiveAttacks(enemy, damage);;
        }
    }

    private void typeEffectiveAttacks(Pokemon enemy, double damage) {
        switch (enemy.getType()) {
            case "grass" -> {
                damage = (damage * 0.8);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "water" -> {
                damage = (damage * 0.5);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "electric" -> {
                damage = (damage * 1);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "fire" -> {
                damage = (damage * 2);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }
        }
        System.out.println("Your opponents pokemon has " + enemy.getHp() + " left.");
    }
}
