public  class MainCaozhaohong{
    public static void main(String[] args){
        Material[] materials1= new Material[3];
        
        materials1[0]= new Material("A",100,1031);
        materials1[1]= new Material("B",120,1030);
        materials1[2]= new Material("C",150,1027);
        DirectMaterial directMaterials1=new DirectMaterial(materials1);
        //1aの工程
        
        Material[] materials1b= new Material[3];
        
        materials1b[0]= new Material("A",100,1050);
        materials1b[1]= new Material("B",120,1050);
        materials1b[2]= new Material("C",150,1050);
        DirectMaterial directMaterials1b=new DirectMaterial(materials1b);
        
        
        CostItem[] items1=new CostItem[4];
        
        items1[0]=new CostItem("第一工程間接材料費",200000);
        items1[1]=new CostItem("第一工程間接労務費",180000);
        items1[2]=new CostItem("第一工程減価償却費",1400000);
        items1[3]=new CostItem("その他",500000);
        ManufacturingExpense manufacturingExpense1=new ManufacturingExpense(items1,1000);
        
        
        double directLaborRate1=2200;
        double directLaborHours1=9.0+20.0/60.0;
        
        Operation operation1=new Operation(directMaterials1,manufacturingExpense1,
        directLaborRate1,directLaborHours1,1020,null);
        
        Operation operation1b=new Operation(directMaterials1b,manufacturingExpense1,
        directLaborRate1,directLaborHours1,1025,null);
        
        System.out.println("第一工程");
        System.out.println(operation1);
        System.out.println(operation1b);
        
        // Operation[] operations = new Operation[1];
        // operations[0]= operation1;
        
        
        main2(new Operation[]{operation1,operation1b});
    }

    public static void main2(Operation[] preOperations){
        
        Material[] materials2= new Material[3];
        
        materials2[0]= new Material("d",150,1020);
        materials2[1]= new Material("e",200,1016);
        materials2[2]= new Material("f",250,1012);
        DirectMaterial directMaterials2=new DirectMaterial(materials2);
         
        CostItem[] items2=new CostItem[4];
        
        items2[0]=new CostItem("第2工程間接材料費",200000);
        items2[1]=new CostItem("第2工程間接労務費",200000);
        items2[2]=new CostItem("第2工程減価償却費",1300000);
        items2[3]=new CostItem("その他",600000);
        ManufacturingExpense manufacturingExpense2=new ManufacturingExpense(items2,1100);
                
        double directLaborRate2=2200;
        double directLaborHours2=9.0+5.0/60.0;
        
        Operation operation2=new Operation(directMaterials2,manufacturingExpense2,
        directLaborRate2,directLaborHours2,1010,preOperations);
        
        System.out.println("\n第二工程");
        System.out.println(operation2);
       
    }
} 