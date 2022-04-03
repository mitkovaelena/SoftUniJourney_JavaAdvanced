package rpg;

public interface Target {
    void takeAttack(int attackPoints);

    int getHealth();

    int giveExperience();

    Weapon dropLoot(RandomProvider random);

    boolean isDead();
}
