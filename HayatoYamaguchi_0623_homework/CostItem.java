public class CostItem
{
    public String name;
    public double amount;

    public CostItem(String name,double amount){
        this.name=name;
        this.amount=amount;

    } 

    public double getAmount(){
        return this.amount;
    }

    @Override
    public String toString(){
        return this.name+"は"+this.amount+"円";
    }      

}
