class DirectMaterial{
    Material[] materials;
    public DirectMaterial(Material[] materials){
        this.materials=materials;
    }

    public double calculate(){
        double sum=0;
        for(int i=0;i<this.materials.length;i++){
            sum=sum+(materials[i].calcMaterial());
        }
        return sum;
    }

    public String hyozi(){
        String contents = "";
        for(int i=0;i<this.materials.length;i++){
            contents += this.materials[i].name + "を"
            + this.materials[i].quantity + "個\n";
        }
        return contents;
    }

    @Override
    public String toString(){
        String massage="";
        for(int i=0;i<this.materials.length;i++){
            massage+=materials[i].toString()+"\n";
            //バックスラッシュは￥マークとオプションボタンを押す
            //バックスラッシュnで改行した状態で表示される
        }
        return massage;
    }    
}