package e02_Blobs.models.blobs;

import e02_Blobs.interfaces.Attack;
import e02_Blobs.interfaces.Behaviour;
import e02_Blobs.interfaces.Blob;

public class BlobImpl implements Blob {
    private String name;
    private int initialHealth;
    private int health;
    private int damage;
    private int damageBeforeTriggering;
    private Behaviour behaviour;
    private Attack attack;
    private boolean isTriggeredBehaviour;
    private boolean isDead;

    public BlobImpl(String name, int health, int damage, Behaviour behaviour, Attack attack) {
        this.name = name;
        this.initialHealth = health;
        this.health = health;
        this.damage = damage;
        this.damageBeforeTriggering = 0;
        this.behaviour = behaviour;
        this.attack = attack;
        this.isTriggeredBehaviour = false;
        this.isDead = false;
    }

    @Override
    public void triggerBehavior() {
        this.isTriggeredBehaviour = true;
        this.damageBeforeTriggering = this.getDamage();
        this.behaviour.trigger(this);
    }

    @Override
    public void attack(Blob blob) {
        if(isDead){
            return;
        }
        this.attack.executeAttack(this, blob);
    }

    @Override
    public void receiveAttack(int damage) {
        if (isDead) {
            return;
        }
        this.setHealth(this.getHealth() - damage);
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        if(health < 0){
            health = 0;
            this.isDead = true;
        }
        this.health = health;

        if (this.getHealth() <=this.initialHealth/2 && !isTriggeredBehaviour){
            this.triggerBehavior();
        }
    }

    @Override
    public int getDamageBeforeTriggering() {
        return damageBeforeTriggering;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void updateStats(){
        if(this.isTriggeredBehaviour) {
            this.behaviour.updateStats(this);
        }
    };

    @Override
    public String toString() {
        if (isDead) {
            return String.format("Blob %s KILLED", this.name);
        }
        return String.format("Blob %s: %s HP, %s Damage", this.name, this.getHealth(), this.getDamage());
    }
}
