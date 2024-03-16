public abstract class GameCharacter {
    private int id;
    private String charName;
    private int charDamage;
    private int charHealth;
    private int charGold;

    public GameCharacter(int id, String name, int damage, int health, int gold) {
        this.id = id;
        this.charName = name;
        this.charDamage = damage;
        this.charHealth = health;
        this.charGold = gold;
    }

    public int getCharDamage() {
        return charDamage;
    }

    public void setCharDamage(int charDamage) {
        this.charDamage = charDamage;
    }

    public int getCharHealth() {
        return charHealth;
    }

    public void setCharHealth(int charHealth) {
        this.charHealth = charHealth;
    }

    public int getCharGold() {
        return charGold;
    }

    public void setCharGold(int charGold) {
        this.charGold = charGold;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
