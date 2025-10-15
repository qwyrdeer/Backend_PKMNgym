import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class FirePokemon extends Pokemon {
    List<String> attacks = Arrays.asList("firelash", "flameThrower", "pyroball", "inferno");

    public FirePokemon(String name, int level, int hp, String food, String sound) {
        super(name, level, hp, food, sound, "fire");
    }

    public List<String> getAttacks() {
        return attacks;
    }

    void fireLash(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used fire lash");
        double damage = 50;
        typeEffectiveAttacks(enemy, damage);
    }

    void flameThrower(Pokemon name, Pokemon enemy) {
        System.out.println(name.getName() + " used flamethrower");
        double damage = 25;
        typeEffectiveAttacks(enemy, damage);
    }

    void pyroBall(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int throwTimes = rand.nextInt(5);
        System.out.println(name.getName() + " throws " + throwTimes + " pyroballs");
//        double damage = 10 * throwTimes;
        double damage = 10;
        for (int i = 0; i < throwTimes; i++) {
            typeEffectiveAttacks(enemy, damage);
            damage = damage + i;
        }
    }

    void inferno(Pokemon name, Pokemon enemy) {
        Random rand = new Random();
        int accuracyAttack = rand.nextInt(100);
        System.out.println(name.getName() + " used inferno");
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
                damage = (damage * 2);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "water" -> {
                damage = (damage * 1);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "electric" -> {
                damage = (damage * 0.8);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }

            case "fire" -> {
                damage = (damage * 0.5);
                System.out.println(enemy.getName() + " loses " + damage + " hp.");
                enemy.setHp((int) (enemy.getHp() - damage));
            }
        }
        System.out.println("Your opponents pokemon has " + enemy.getHp() + " left.");
    }
}
