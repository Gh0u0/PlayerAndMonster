import java.util.Random;

public class Monster extends Creature implements AttackMechanic {
    Random random = new Random();

    @Override
    public int calculateAttackModifier(int attack, int defence) {
        int attackModifier = attack - defence + 1;
        if (attackModifier < 1) {
            attackModifier = 1;
        }
        return attackModifier;
    }

    @Override
    public boolean attackSuccess(int attackModifier) {
        for (int i = 0; i < attackModifier; i++) {
            int dice = random.nextInt(6) + 1;
            if (dice > 4) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int takeDamage(int amount) {
        amount = damage;
        hp -= amount;
        return amount;
    }

    public void attackEnemy(Player target) {
        damage = random.nextInt(6) + 1;
        int damageTaken = target.takeDamage(damage);
        System.out.printf("Монстр нанес игроку %d ед. урона \n", damageTaken);
    }

    public void info() {
        System.out.printf("Монстр\n Здоровье: %d/%d Атака: %d Защита: %d \n", hp, maxHp, attack, defence);
    }

}
