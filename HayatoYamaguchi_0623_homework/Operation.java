public class Operation{
    DirectMaterial directMaterial;
    ManufacturingExpense manufacturingExpense;
    double directLaborRate;
    double directLaborHours;
    double quantity;
    Operation[] preOperations;

    public Operation(DirectMaterial directMaterial,ManufacturingExpense
    manufacturingExpense,double directLaborRate,double directLaborHours, 
    double quantity,Operation[] preOperations){

        this.directMaterial=directMaterial;
        this.manufacturingExpense=manufacturingExpense;
        this.directLaborRate=directLaborRate;
        this.directLaborHours=directLaborHours;
        this.quantity=quantity;
        this.preOperations=preOperations;
    }

    public  double calcTotalCost(){
        double sum=directMaterial.calculate()+manufacturingExpense.calcCost()
            *directLaborHours+directLaborRate* directLaborHours+this.calcPreOperationExpense();
        return sum;
    }

    public String calcUnitCost(){
        return "単位当たりコストは"+this.calcTotalCost()/quantity;
    }

    private double calcPreOperationExpense(){
        if(preOperations!=null){
            double sum=0;
            for(int i=0;i<preOperations.length;i++){
                sum+=preOperations[i].calcTotalCost();
            }
            return sum;
        }else{
            return 0;
        }
    }
    
    public  String totalcost(){
        return "合計コストは" +this.calcTotalCost()+"円";
    }
    
    

    @Override
    public String toString(){
     
        String message="";
        if(preOperations!=null){
            message="\n前工程の内訳：\n";
            for(int i=0;i<preOperations.length;i++){
                message+= preOperations[i].toString()+"\n";
            }
        }
        
        return message+"各材料\n"+directMaterial.hyozi()+
        "作業時間は" + directLaborHours+"時間\n"
        +totalcost()+"\n"+calcUnitCost();
    }   
    //op1Aop１Bの２つを作る（op1の中で）
    //この二つは同じ材料を使っている
    // a1040, b1050, c1050と個数を変える（9時間2200分のまま）
    // op2でこの二つを統合してnewする
    //op1a1bがそれぞれいくつ使っているかを出す
    //materialクラスの中で、equalsメソッドを実装して名前が同じならtrueを返すようなプログラムを作る
    //数量をtoStringで表示するようにする

    //preoperationで前工程のtoStringを返すようにする→nullになるまで返し続ける
    //Operationクラスの工程を改造するだけ
    //前工程の内訳まできれいに表示するようにする

    // public Operation calcUnitOperation(){
    // new Operation()
    // }

}