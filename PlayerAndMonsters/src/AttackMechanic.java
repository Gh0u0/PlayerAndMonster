public interface AttackMechanic {
    int calculateAttackModifier(int attack, int defence);
    boolean attackSuccess(int attackModifier);
    int takeDamage (int amount);
    void info();

}
