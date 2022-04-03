package app.waste_disposal.models.waste;

import app.waste_disposal.contracts.Waste;

public abstract class BaseWaste implements Waste {
    private String name;
    private double weight;
    private double volumePerKg;

    protected BaseWaste(String name, double weight, double volumePerKg) {
        this.setName(name);
        this.setWeight(weight);
        this.setVolumePerKg(volumePerKg);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    private void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }
}
