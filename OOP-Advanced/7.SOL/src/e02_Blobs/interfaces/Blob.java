package e02_Blobs.interfaces;

public interface Blob {

    void triggerBehavior();

    void attack(Blob blob);

    void receiveAttack(int damage);

    int getDamage();

    void setDamage(int damage);

    int getHealth();

    void setHealth(int health);

    int getDamageBeforeTriggering();

    String getName();

    void updateStats();
}
