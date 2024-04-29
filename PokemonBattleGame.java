import java.util.Random;
import java.util.Scanner;

class PokemonBattleGame {
    private Random rand;
    private Scanner scan;

    public PokemonBattleGame() {
        rand = new Random();
        scan = new Scanner(System.in);
    }

    public void start() {
        String yourPokemonNickname;
        String rivalPokemonNickname;
        double rivalPokemonHealth = rand.nextDouble() * (60 - 40) + 40;

        System.out.print("Enter your Pokemon’s nickname: ");
        yourPokemonNickname = scan.nextLine().trim();

        System.out.print("Enter your rival Pokemon’s nickname: ");
        rivalPokemonNickname = scan.nextLine().trim();

        System.out.println("Your rival has chosen " + rivalPokemonNickname + " to fight, which has "
                + rivalPokemonHealth + " health.");

        int totalTurns = 0;
        do {
            AttackType attack = AttackType.values()[rand.nextInt(3)];
            double damage = 0;

            switch (attack) {
                case TACKLE:
                    damage = rand.nextDouble() * (9.0 - 7.0) + 7.0;
                    break;
                case SCRATCH:
                    int scratchTimes = rand.nextInt(3) + 1;
                    double scratchDamage = rand.nextDouble() * (6.0 - 1.0) + 1.0;
                    damage = scratchTimes * scratchDamage;
                    break;
                case SURF:
                    damage = rand.nextDouble() * (11.0 - 2.0) + 2.0;
                    break;
            }

            rivalPokemonHealth -= damage;
            rivalPokemonHealth = Math.max(rivalPokemonHealth, 0);

            System.out.println(yourPokemonNickname + " used " + attack + " and did "
                    + String.format("%.2f", damage) + " damage. Your rival has "
                    + String.format("%.2f", rivalPokemonHealth) + " health remaining.");

            totalTurns++;
        } while (rivalPokemonHealth > 0);

        System.out.println(rivalPokemonNickname + " fainted after " + totalTurns + " turns!");
        double prizeMoney = rand.nextDouble() * (2400.0 - 1200.0) + 1200.0;
        System.out.printf("You have earned $%.2f!", prizeMoney);

        scan.close();
    }
}

enum AttackType {
    TACKLE,
    SCRATCH,
    SURF
}
