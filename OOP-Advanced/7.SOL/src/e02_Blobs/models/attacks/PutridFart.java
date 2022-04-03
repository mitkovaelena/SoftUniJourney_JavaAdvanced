package e02_Blobs.models.attacks;

import e02_Blobs.interfaces.Attack;
import e02_Blobs.interfaces.Blob;

public class PutridFart implements Attack {

    public PutridFart() {
    }

    @Override
    public void executeAttack(Blob attacker, Blob target) {
        target.receiveAttack(attacker.getDamage());
    }
}
