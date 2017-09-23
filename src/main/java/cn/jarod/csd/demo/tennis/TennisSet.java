package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

public class TennisSet {

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
        if (server.getScore() == receiver.getScore() && server.getScore() < DEUCE_SCORE) {
            return scoreArr[server.getScore()] + " All";
        }
        if (server.getScore() == receiver.getScore()) {
            return "Deuce";
        }
        if (overDeuceScoreOrNot(server, receiver) && advPlayer.getScore() - unAdvPlayer.getScore() < WIN_SCORE) {
            return advPlayer.getName() + ADV;
        }
        if (overDeuceScoreOrNot(server, receiver)) {
            return advPlayer.getName() + WIN;
        }
        return scoreArr[server.getScore()] + " " + scoreArr[receiver.getScore()];
    }

    private boolean overDeuceScoreOrNot(TennisPlayer server, TennisPlayer receiver) {
        if (server.getScore() > receiver.getScore()) {
            advPlayer = server;
            unAdvPlayer = receiver;
        } else {
            advPlayer = receiver;
            unAdvPlayer = server;
        }
        if (advPlayer.getScore() > DEUCE_SCORE) {
            return true;
        }
        return false;
    }

    private String getAdvPlayerName(){
        return server.getScore()> receiver.getScore()? server.getName() :receiver.getName();
    }


    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet(serverName, receiverName);
    }
}