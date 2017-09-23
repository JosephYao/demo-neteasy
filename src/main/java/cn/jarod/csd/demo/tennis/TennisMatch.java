package cn.jarod.csd.demo.tennis;

import cn.jarod.csd.demo.Contants;

import java.util.ArrayList;
import java.util.List;


public class TennisMatch {


    List<String> winPlayer;

    private TennisPlayer server;

    private TennisPlayer receiver;


    public void setWinPlayer(List<String> winPlayer) {
        this.winPlayer = winPlayer;
    }


    public TennisMatch(String serverName, String receiverName){
        if (server==null) server =  new TennisPlayer(serverName);
        if (receiver==null) receiver =  new TennisPlayer(receiverName);
        if (winPlayer==null) setWinPlayer(new ArrayList<String>());
    }

    public String printMatch() {
        for (String name : winPlayer) takeSetResult(name);
        return server.getMatchNameString(receiver.getScore()) + " (" + server.getScore() + ":" + receiver.getScore() + ") " + receiver.getMatchNameString(receiver.getScore());
    }


    private void takeSetResult(String name) {
        if (server.isThisPlayer(name)) server.playerGetPoint();
        if (receiver.isThisPlayer(name)) receiver.playerGetPoint();
    }

    public void addOneSet(String player){
        winPlayer.add(player.substring(0,player.indexOf(Contants.WIN_STR)));
    }
}
