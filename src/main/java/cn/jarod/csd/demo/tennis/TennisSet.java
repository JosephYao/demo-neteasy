package cn.jarod.csd.demo.tennis;

public class TennisSet {

    public static final String WIN = " Win";

    public static final String ADV = " Adv";

    private TennisPlayer receiver;

    private TennisPlayer server;

    public TennisPlayer getReceiver() {
        return receiver;
    }

    public TennisPlayer getServer() {
        return server;
    }


    private String[] scoreArr = {"Love", "Fifteen", "Thirty", "Forty", "Win"};

    private TennisSet(String serverName, String receiverName) {
        server = new TennisPlayer(serverName);
        receiver = new TennisPlayer(receiverName);
    }


    public String printScore() {
        if (server.isSamePoint(receiver)) {
            return scoreArr[server.getScore()] + " All";
        }
        if (server.isDeuce(receiver)) {
            return "Deuce";
        }
        if (server.isAdvantage(receiver)) {
            return server.getAdvPlayerName(receiver) + ADV;
        }
        if (server.isOverDeuceScore(receiver)) {
            return server.getAdvPlayerName(receiver) + WIN;
        }
        return scoreArr[server.getScore()] + " " + scoreArr[receiver.getScore()];
    }

    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet(serverName, receiverName);
    }
}