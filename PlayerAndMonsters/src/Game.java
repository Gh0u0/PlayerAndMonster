import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player = new Player();
    private Monster monster = new Monster();

    public void init() {
        System.out.println("Создайте игрока: ");
        player.setAttack(0);
        player.setDefence(0);
        player.setMaxHp(0);
        player.setHp(0);

        System.out.println("Создайте монстра: ");
        monster.setAttack(0);
        monster.setDefence(0);
        monster.setMaxHp(0);
        monster.setHp(0);
    }

    public void start() {
        System.out.println("Игра началась");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (!player.isAlive()) {
                System.out.println("Кажется вы не справились с монстром");
                return;
            }
            System.out.println("Ваш ход: ");
            int action = InputSystem.select("1. Атаковать 2. Вылечиться", 1, 2);
            if (action == 1) {
                int attackModifier = player.calculateAttackModifier(player.attack, monster.defence);
                if (player.attackSuccess(attackModifier)) {
                    player.attackEnemy(monster);
                } else {
                    System.out.println("Атака не удалась");
                }
            } else {
                player.useHeal();
            }

            if (!monster.isAlive()) {
                System.out.println("Поздравляю с победой");
                return;
            }
            System.out.println("Ход монстра: ");
            int attackModifier = monster.calculateAttackModifier(monster.attack, player.defence);
            if (monster.attackSuccess(attackModifier)) {
                monster.attackEnemy(player);
            } else {
                System.out.println("Атака не удалась");
            }
            player.info();
            monster.info();

        }
    }
}
