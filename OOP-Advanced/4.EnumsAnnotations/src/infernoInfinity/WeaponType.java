package infernoInfinity;

public enum WeaponType {
    AXE(5,10,4), SWORD(4,6,3), KNIFE(3,4,2);

    private int minDamage;
    private int maxDamage;
    private int numSockets;

    WeaponType( int minDamage, int maxDamage, int numSockets) {
        this.maxDamage = maxDamage;
        this.minDamage = minDamage;
        this.numSockets = numSockets;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public int getNumSockets() {
        return numSockets;
    }
}
