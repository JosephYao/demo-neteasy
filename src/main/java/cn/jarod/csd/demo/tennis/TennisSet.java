package cn.jarod.csd.demo.tennis;

import java.util.ArrayList;
import java.util.List;

public class TennisSet {

    private static final String WIN = " Win";

    private static final String ADV = " Adv";

    private final TennisPlayer receiver;

    private final TennisPlayer server;

    public TennisPlayer getReceiver() {
        return receiver;
    }

    public TennisPlayer getServer() {
        return server;
    }


    private final String[] scoreArr = {"Love", "Fifteen", "Thirty", "Forty", "Win"};

    private TennisSet(String serverName, String receiverName) {
        server = new TennisPlayer(serverName);
        receiver = new TennisPlayer(receiverName);
    }

    public String printScore() {
        List<SetRuleAndScore> setRuleAndScores = new ArrayList<SetRuleAndScore>() {{
            add(new SetRuleAndScore(server.isSamePoint(receiver), getScoreText(server.getScore()) + " All"));
            add(new SetRuleAndScore(server.isDeuce(receiver), "Deuce"));
            add(new SetRuleAndScore(server.isAdvantage(receiver), server.getAdvPlayerName(receiver) + ADV));
            add(new SetRuleAndScore(server.isOverDeuceScore(receiver), server.getAdvPlayerName(receiver) + WIN));
            add(new SetRuleAndScore(true, getScoreText(server.getScore()) + " " + getScoreText(receiver.getScore())));
        }};

        return setRuleAndScores.stream().filter(SetRuleAndScore::isMatched).findFirst().get().score();
    }

    private String getScoreText(int score) {
        return (score >= scoreArr.length) ? "" : scoreArr[score];
    }

    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet(serverName, receiverName);
    }
}