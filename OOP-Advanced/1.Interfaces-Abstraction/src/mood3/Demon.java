package mood3;

public class Demon extends GameObject{
    private Double specialPoints;

    public Demon(String username, String type, Double specialPoints, Integer level) {
        super(username,type, level);
        this.specialPoints = specialPoints;
        super.setHashedPassword(this.generateHashedPassword());
    }

    private String generateHashedPassword() {
        return String.valueOf(super.getUsername().length()*217);
    }

    @Override
    public String toString() {
        return super.toString() + this.specialPoints*super.getLevel();

    }
}
