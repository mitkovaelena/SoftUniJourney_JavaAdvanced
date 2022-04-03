package e02_Blobs.models.behaviours;

import e02_Blobs.interfaces.Behaviour;
import e02_Blobs.interfaces.Blob;

public class Aggressive implements Behaviour {
    private static final int DAMAGE_LOSS = 5;
    private static final int DAMAGE_GAIN_COEF = 2;

    public Aggressive() {
    }

    @Override
    public void trigger(Blob blob) {
        blob.setDamage(blob.getDamage()*DAMAGE_GAIN_COEF);
    }

    @Override
    public void updateStats(Blob blob) {
        if(blob.getDamage()-DAMAGE_LOSS >= blob.getDamageBeforeTriggering()) {
            blob.setDamage(blob.getDamage() - DAMAGE_LOSS);
        }
    }
}
