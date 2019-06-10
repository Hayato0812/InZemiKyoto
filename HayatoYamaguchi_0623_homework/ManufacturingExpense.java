public class ManufacturingExpense
{
    CostItem[] items;
    double directLaborHours;
    public ManufacturingExpense(CostItem[] items, double directLaborHours){
        this.items=items;
        this.directLaborHours=directLaborHours;
    }

    public double calcCost(){
        double sum=0;
        for(int i=0;i<this.items.length;i++){
            sum=sum+(items[i].getAmount());
        }
        return sum/this.directLaborHours;
    }

    // public double calcMinutes(double hours,double minutes){
    // return hours*60+minutes;
    // }  

    @Override
    public String toString(){
        String massage="";
        for(int i=0;i<this.items.length;i++){
            massage+=items[i].toString()+"\n";
            //バックスラッシュは￥マークとオプションボタンを押す
            //バックスラッシュnで改行した状態で表示される
        }
        return massage;
    }    
}
