package cn.jarod.csd.demo.tennis;

public class SetRuleAndScore {
    private final boolean isRuleMatched;
    private final String score;

    public SetRuleAndScore(boolean isRuleMatched, String score) {
        this.isRuleMatched = isRuleMatched;
        this.score = score;
    }

    public boolean isMatched() {
        return isRuleMatched;
    }

    public String score() {
        return score;
    }
}
