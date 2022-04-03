package infernoInfinity;

@Anno(author = "Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements IWeapon, Comparable<Weapon> {
    private WeaponType type;
    private String name;
    private int maxDamage;
    private int minDamage;
    private Gem[] gems;

    protected Weapon( String weaponType, String name) {
       this.setType(weaponType);
       this.name = name;
       this.maxDamage = this.type.getMaxDamage();
       this.minDamage = this.type.getMinDamage();
       this.gems = new Gem[this.type.getNumSockets()];
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setType(String type) {
        this.type = Enum.valueOf(WeaponType.class, type.toUpperCase());
    }

    public void insertGem(int ind, String gemType){
        Gem gem =  Enum.valueOf(Gem.class, gemType.toUpperCase());
        if(ind < gems.length && ind >=0 ) {
            if (gems[ind] == null) {
                gems[ind] = gem;
            } else {
                removeGem(ind);
                gems[ind] = gem;
            }
            this.minDamage += gem.getStrength() * 2 + gem.getAgility();
            this.maxDamage += gem.getStrength() * 3 + gem.getAgility() * 4;
        }
    }

    public void removeGem(int ind) {
        Gem gem;
        if (ind < gems.length && ind >= 0) {
            if (gems[ind] != null) {
                gem = gems[ind];
                gems[ind] = null;
                this.minDamage -= gem.getStrength() * 2 + gem.getAgility();
                this.maxDamage -= gem.getStrength() * 3 + gem.getAgility() * 4;
            }
        }
    }

    @Override
    public String toString() {
        int[] stats = calculateStats(this);

        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name, this.minDamage, this.maxDamage, stats[0], stats[1], stats[2]);
    }

    @Override
    public int compareTo(Weapon w) {
        return (int) Math.ceil(calculateLvl(this) - calculateLvl(w));
    }

    private int[] calculateStats(Weapon w){
        int strength = 0;
        int agility = 0;
        int vitality = 0;

        for(Gem g : gems){
            if (g == null) continue;
            strength += g.getStrength();
            agility += g.getAgility();
            vitality += g.getVitality();
        }
        int[] stats = {strength,agility,vitality};
        return stats;
    }

    private double calculateLvl(Weapon w){
        int[] stats = calculateStats(w);

        return (double)(w.getMaxDamage() + w.getMinDamage())/2 + stats[0] + stats[1] + stats[2];
    }

    public String printLvl(){
        return String.format("(Item Level: %.1f)", calculateLvl(this) );
    }
}
