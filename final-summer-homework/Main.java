public class Main {
    public static void main(String[] args) {

        //技の定義
        Move move1 = new Move("ひっかく", "ノーマル", 40);
        Move move2 = new Move("たいあたり", "ノーマル", 50);
        Move move3 = new Move("ひのこ", "ほのお", 40);
        Move move4 = new Move("みずでっぽう", "みず", 40);
        Move move5 = new Move("はっぱカッター", "くさ", 40);

        Move[] pokemon1Moves = new Move[]{move1, move3};
        Move[] pokemon2Moves = new Move[]{move2, move4};
        Move[] pokemon3Moves = new Move[]{move2, move5};
        Move[] pokemon4Moves = new Move[]{move2};

        //ポケモンの定義
        Pokemon pokemon1 = new Pokemon("ヒトカゲ", "ほのお", 10, 50, 35, 25, 35, pokemon1Moves);
        Pokemon pokemon2 = new Pokemon("ゼニガメ", "みず", 10, 50, 25, 35, 25, pokemon2Moves);
        Pokemon pokemon3 = new Pokemon("フシギダネ", "くさ", 10, 50, 30, 20, 30, pokemon3Moves);
        Pokemon pokemon4 = new Pokemon("コラッタ", "ノーマル", 7, 30, 25, 20, 30, pokemon4Moves);

        //バトルするポケモンの組み合わせ
        CalcDamage calcDamage1 = new CalcDamage();
        Battle battle1 = new Battle(pokemon1, pokemon2, calcDamage1);

        CalcDamage calcDamage2 = new CalcDamage();
        Battle battle2 = new Battle(pokemon3, pokemon4, calcDamage2);

        //バトルの結果
        System.out.println(battle1);
        System.out.println(battle2);
    }
}


