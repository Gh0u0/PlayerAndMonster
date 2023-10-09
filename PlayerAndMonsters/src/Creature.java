public abstract class Creature {
    int attack;
    int defence;
    int maxHp;
    int hp;
    int damage;



    public void setAttack(int attack) {
        this.attack = InputSystem.select("Введите атаку(число от 1 до 30): ", 1, 30);
    }

    public void setDefence(int defence) {
        this.defence = InputSystem.select("Введите защиту(число от 1 до 30): ", 1, 30);
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = InputSystem.select("Введите здоровье(число от 1 до 100): ", 1, 100);
    }

    public void setHp(int hp) {
        this.hp = maxHp;
    }

    public boolean isAlive() {
        return hp > 0;
    }

}
