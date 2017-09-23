package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

public class TennisPlayer {

    private static final int DEUCE_SCORE = 3;
    private static final int WIN_SCORE = 2;
    private final String name;

    private int score;

    public TennisPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void playerGetPoint(){
        score ++;
    }

    private TennisPlayer advPlayer(TennisPlayer another) {
        return score > another.score ? this : another;
    }

    public boolean isOverDeuceScore(TennisPlayer another) {
        return advPlayer(another).score > DEUCE_SCORE;
    }

    public boolean isSamePoint(TennisPlayer another) {
        return score == another.score && score < DEUCE_SCORE;
    }

    public boolean isDeuce(TennisPlayer another) {
        return score == another.score;
    }

    public boolean isAdvantage(TennisPlayer another) {
        return isOverDeuceScore(another) && advDiffScore(another) < WIN_SCORE;
    }

    private int advDiffScore(TennisPlayer another) {
        return score > another.score ? score - another.score : another.score - score;
    }

    public String getAdvPlayerName(TennisPlayer receiver) {
        return advPlayer(receiver).getName();
    }

    public boolean isThisPlayer(String _name){
        return name.equals(_name)? true : false;
    }

    private boolean isWinMatch(int score, int antherScore) {
        return score > Contants.TIE_BREAK || (score == Contants.TIE_BREAK && antherScore < Contants.NEED_7);
    }

    public String getMatchNameString(int antherscore) {
        return isWinMatch(score, antherscore)? name + Contants.WIN_STR : name;
    }
}
