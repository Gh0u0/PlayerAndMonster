import java.util.Random;

public class Player extends Creature implements AttackMechanic {
    Random random = new Random();
    int healCounter = 4;

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
        this.damage = amount;
        hp -= amount;
        return amount;
    }


    public void attackEnemy(Monster target) {
        int damage = random.nextInt(6) + 1;
        int damageTaken = target.takeDamage(damage);
        System.out.printf("Игрок нанес монстру %d ед. урона \n", damageTaken);
    }

    public void useHeal() {
        if (healCounter > 0) {
            int heal = (int) (maxHp * 0.3);
            if (hp + heal > maxHp) {
                heal = maxHp - hp;
                hp = maxHp;
            } else {
                hp = hp + heal;
            }
            System.out.printf("Вы излечили себя на %d ед. здоровья \n", heal);
            healCounter --;
        } else {
            System.out.println("Вы попытались сделать глоток зелья, но на дне бутылки оказалось пусто.\nМонстр воспользовался моментом чтобы ударить.");
        }
    }

    public void info() {
        System.out.printf("Игрок\n Здоровье: %d/%d Атака: %d Защита: %d Зелье лечения: %d/4 \n", hp, maxHp, attack, defence, healCounter);
    }

}
