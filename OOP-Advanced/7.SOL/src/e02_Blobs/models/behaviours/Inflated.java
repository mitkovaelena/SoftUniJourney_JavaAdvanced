package e02_Blobs.models.behaviours;

import e02_Blobs.interfaces.Behaviour;
import e02_Blobs.interfaces.Blob;

public class Inflated implements Behaviour {
    private static final int HELTH_LOSS = 10;
    private static final int HELTH_GAIN = 50;

    public Inflated() {
    }

    @Override
    public void trigger(Blob blob) {
        blob.setHealth(blob.getHealth() + HELTH_GAIN);
    }

    @Override
    public void updateStats(Blob blob) {
        blob.setHealth(blob.getHealth() - HELTH_LOSS);
    }
}
