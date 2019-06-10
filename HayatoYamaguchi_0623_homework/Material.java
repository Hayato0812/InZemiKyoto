class Material{
public String name;
public double price;
public double quantity;

public Material(String name,double price,double quantity){
   this.name=name;
   this.price=price;
   this.quantity=quantity;
} 


public double calcMaterial(){
    return this.price*this.quantity;
}

 @Override
public String toString(){
return this.name+"は"+this.price+"円で"+this.quantity+"個";
}   
 
}

