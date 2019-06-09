public class Pokemon {
    private String name;
    private String type;
    private double level;
    private int hp;
    private double attack;
    private double defense;
    private double speed;
    private Move[] moves;

    public Pokemon(String name, String type, double level, int hp, double attack, double defense, double speed, Move[] moves) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getLevel(){
        return level;
    }

    public int getHp(){
        return hp;
    }

    public double getAttack() {
        return attack;
    }

    public double getDefense() {
        return defense;
    }

    public double getSpeed() {
        return speed;
    }

    public Move[] getMoves() {
        return moves;
    }



}
