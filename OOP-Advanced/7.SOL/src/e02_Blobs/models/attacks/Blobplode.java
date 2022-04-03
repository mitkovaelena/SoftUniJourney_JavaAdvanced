package e02_Blobs.models.attacks;

import e02_Blobs.interfaces.Attack;
import e02_Blobs.interfaces.Blob;

public class Blobplode implements Attack {
    private static final int HEALTH_LOSS_COEF = 2;
    private static final int DAMAGE_GAIN_COEF = 2;

    public Blobplode() {
    }

    @Override
    public void executeAttack(Blob attacker, Blob target) {
        if(attacker.getHealth()>1) {
            attacker.setHealth(attacker.getHealth() - attacker.getHealth() / HEALTH_LOSS_COEF);
        }
        target.receiveAttack(DAMAGE_GAIN_COEF*attacker.getDamage());
    }
}
