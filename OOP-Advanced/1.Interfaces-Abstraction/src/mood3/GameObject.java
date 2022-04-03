package mood3;

public abstract class GameObject implements IGameObject {
    private String username;
    private String hashedPassword;
    private Integer level;
    private String type;

    public GameObject(String username, String type, Integer level) {
        this.username = username;
        this.type = type;
        this.level = level;
    }

    protected void setHashedPassword(String hashedPassword){
        this.hashedPassword = hashedPassword;
    }

    public Integer getLevel() {
        return level;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return String.format("\"%s\" | \"%s\" -> %s%n", this.getUsername(), this.hashedPassword, this.type);
    }
}
