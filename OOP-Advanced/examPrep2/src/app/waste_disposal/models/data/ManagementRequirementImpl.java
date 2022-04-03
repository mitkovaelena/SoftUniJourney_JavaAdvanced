package app.waste_disposal.models.data;

public class ManagementRequirementImpl implements ManagementRequirement {
    private double minEnergyBalance;
    private double minCapitalBalance;
    private String deniedGarbage;

    public ManagementRequirementImpl(double minEnergyBalance, double minCapitalBalance, String deniedGarbage) {
        this.minEnergyBalance = minEnergyBalance;
        this.minCapitalBalance = minCapitalBalance;
        this.deniedGarbage = deniedGarbage;
    }

    public double getMinEnergyBalance() {
        return minEnergyBalance;
    }

    public double getMinCapitalBalance() {
        return minCapitalBalance;
    }

    public String getDeniedGarbage() {
        return deniedGarbage;
    }
}
