public class Battle {
    private Pokemon me;
    private Pokemon opponent;
    private CalcDamage calcDamage;
    private int meHp;
    private int opponentHp;

    public Battle(Pokemon me, Pokemon opponent, CalcDamage calcDamage) {
        this.me = me;
        this.opponent = opponent;
        this.calcDamage = calcDamage;
        opponentHp = opponent.getHp();
        meHp = me.getHp();
    }

    int realMeHp() {
        if (meHp <= 0) {
            return 0;
        } else {
            return meHp;
        }
    }

    int realOpponentHp() {
            if (opponentHp <= 0) {
                return 0;
            } else {
                return opponentHp;
            }
        }

    String msg;
    void myDamage(){
        int myDamage = (int)this.calcDamage.finalizedDamage(opponent, me);
        meHp -= myDamage;
        Move opponentMove = this.calcDamage.randMove(opponent);
        msg += "あいての"+opponent.getName()+"の"+opponentMove+"！";
        if(this.calcDamage.calcType(opponentMove.getType(), me.getType()) == 2){
            msg += "こうかはばつぐんだ！";
        }else if(this.calcDamage.calcType(opponentMove.getType(), me.getType()) == 0.5){
            msg += "こうかはいまひとつのようだ。。。";
        }
        msg += me.getName()+"に"+myDamage+"ダメージ！\n"+me.getName()+"の残りHPは"+realMeHp()+"\n";
    }
    void opponentDamage(){ ;
        int opponentDamage = (int)this.calcDamage.finalizedDamage(me, opponent);
        opponentHp -= opponentDamage;
        Move meMove = this.calcDamage.randMove(me);
        msg += me.getName()+"の"+meMove+"！";
        if(this.calcDamage.calcType(meMove.getType(), opponent.getType()) == 2){
            msg += "こうかはばつぐんだ！";
        }else if(this.calcDamage.calcType(meMove.getType(), opponent.getType()) == 0.5){
            msg += "こうかはいまひとつのようだ。。。";
        }
        msg += "あいての"+opponent.getName()+"に"+opponentDamage+"ダメージ！\n"
                +opponent.getName()+"の残りHPは"+realOpponentHp()+"\n";
    }


    //体力をお互い減らしていって、先にHPがなくなったほうの負けでどちらかが倒れるまでやる
    public double actualBattle() {
    while(meHp>0&&opponentHp>0) {
        if (me.getSpeed() < this.opponent.getSpeed()) {
            myDamage();
            if(meHp<=0){
                break;
            }
            opponentDamage();
        } else if (this.me.getSpeed() > this.opponent.getSpeed()) {
            opponentDamage();
            if(opponentHp<=0){
                break;
            }
            myDamage();
        } else {

            if(Math.random()<0.5){

                myDamage();
                if(meHp<=0){
                    break;
                }
                opponentDamage();
            }else{
                opponentDamage();
                if(opponentHp<=0){
                    break;
                }
                myDamage();
            }
            if(meHp<=0||opponentHp<=0){
                break;
            }
        }
    }
    return 0;
}
    @Override
    public String toString() {
        msg = "";
        msg += "あいては"+opponent.getName()+"をくりだした！いけ、"+me.getName()+"！\n";
        actualBattle();
        if(meHp<=0){
        msg += me.getName()+"はたおれた";
        }else if(opponentHp<=0){
            msg += "あいての"+opponent.getName()+"はたおれた！";
        }
        return msg;
    }
}
