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
        if (overDeuceScoreOrNot(server, receiver) && advPlayer(server, receiver).getScore() - unAdvPlayer(server, receiver).getScore() < WIN_SCORE) {
            return advPlayer(server, receiver).getName() + ADV;
        }
        if (overDeuceScoreOrNot(server, receiver)) {
            return advPlayer(server, receiver).getName() + WIN;
        }
        return scoreArr[server.getScore()] + " " + scoreArr[receiver.getScore()];
    }

    private TennisPlayer advPlayer(TennisPlayer server, TennisPlayer receiver) {
        if (server.getScore() > receiver.getScore()) {
            return server;
        } else {
            return receiver;
        }
    }

    private TennisPlayer unAdvPlayer(TennisPlayer server, TennisPlayer receiver) {
        if (server.getScore() > receiver.getScore()) {
            return receiver;
        } else {
            return server;
        }
    }

    private boolean overDeuceScoreOrNot(TennisPlayer server, TennisPlayer receiver) {
        return advPlayer(server, receiver).getScore() > DEUCE_SCORE;
    }

    public static TennisSet createSet(String serverName, String receiverName) {
        return new TennisSet(serverName, receiverName);
    }
}