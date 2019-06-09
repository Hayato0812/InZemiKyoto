public class CalcDamage {
    double basicDamage(Move thisMove, Pokemon attackSide, Pokemon defenseSide) {
        return (attackSide.getLevel() * 2 / 5 + 2)
                * thisMove.getPower() * attackSide.getAttack() / defenseSide.getDefense() / 50 + 2;
    }
    //攻撃側のレベル × 2 ÷ 5 ＋ 2）× 技の威力 × 攻撃側の能力値 ÷ 防御側の能力値 ÷ 50 ＋ 2

    double calcType(String moveType, String defenseType){
        double num = 1;
        if(moveType == "ほのお"){
            if(defenseType == "みず"){
                num = 0.5;
            }else if(defenseType == "くさ"){
                num = 2;
            }
        }else if(moveType == "みず"){
            if(defenseType == "くさ"){
                num = 0.5;
            }else if(defenseType == "ほのお"){
                num = 2;
            }
        }else if(moveType == "くさ"){
            if(defenseType == "ほのお"){
                num = 0.5;
            }else if(defenseType == "みず"){
                num = 2;
            }
        }
        return num;
    }

    double sameType(String moveType, String attackType){
        double num = 1;
        if(moveType == attackType){
            num = 1.5;
        }
        return num;
    }
    Move randMove(Pokemon attackSide){
        return attackSide.getMoves()[(int)(Math.random()*attackSide.getMoves().length)];
    }

    double finalizedDamage(Pokemon attackSide, Pokemon defenseSide) {
        Move thisMove = randMove(attackSide);
        return basicDamage(thisMove,attackSide,defenseSide)*(Math.random()*0.15+0.85)
                *sameType(thisMove.getType(),attackSide.getType())
                *calcType(thisMove.getType(),defenseSide.getType());
    }
}
