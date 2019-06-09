public class Move {
    private String name;
    private String type;
    private double power;

    public Move(String name, String type, double power){
        this.name = name;
        this.type = type;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPower() {
        return power;
    }

    public String toString(){
        return name;
    }
}
