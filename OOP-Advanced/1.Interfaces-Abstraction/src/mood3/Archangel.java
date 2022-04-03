package mood3;

public class Archangel extends GameObject{
    private Integer specialPoints;

    public Archangel(String username, String type, Integer specialPoints, Integer level) {
        super(username,type,level);
        this.specialPoints = specialPoints;
        super.setHashedPassword(this.generateHashedPassword());
    }

    private String generateHashedPassword() {
        StringBuilder sb = new StringBuilder(super.getUsername()).reverse();
        return sb.toString() +  String.valueOf(super.getUsername().length()*21);
    }

    @Override
    public String toString() {
        return super.toString() +  this.specialPoints*super.getLevel();
    }
}
