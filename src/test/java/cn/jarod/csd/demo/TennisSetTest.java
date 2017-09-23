package cn.jarod.csd.demo;

import cn.jarod.csd.demo.tennis.TennisSet;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class TennisSetTest {

    public TennisSet tennisSet = TennisSet.createSet("Joseph","91");


    private void getPlayerPoint(int serverPoint, int receiverPoint) {
        IntStream.range(0,serverPoint).forEach( score -> {
            tennisSet.getServer().playerGetPoint();
        });
        IntStream.range(0,receiverPoint).forEach( score -> {
            tennisSet.getReceiver().playerGetPoint();
        });
    }

    @Test
    public void Love_All(){
        getPlayerPoint(0,0);
        Assert.assertEquals("Love All",tennisSet.printScore());
    }

    @Test
    public void Fifteen_Love(){
        getPlayerPoint(1,0);
        Assert.assertEquals("Fifteen Love",tennisSet.printScore());
    }

    @Test
    public void Fifteen_All(){
        getPlayerPoint(1,1);
        Assert.assertEquals("Fifteen All",tennisSet.printScore());
    }

    @Test
    public void Thirty_Love(){
        getPlayerPoint(2,0);
        Assert.assertEquals("Thirty Love",tennisSet.printScore());
    }

    @Test
    public void Love_Forty(){
        getPlayerPoint(2,3);
        Assert.assertEquals("Thirty Forty",tennisSet.printScore());
    }

    @Test
    public void Deuce(){
        getPlayerPoint(3,3);
        Assert.assertEquals("Deuce",tennisSet.printScore());
    }

    @Test
    public void Joseph_Win(){
        getPlayerPoint(4,1);
        Assert.assertEquals("Joseph Win",tennisSet.printScore());
    }


    @Test
    public void _91_Win(){
        getPlayerPoint(1,4);
        Assert.assertEquals("91 Win",tennisSet.printScore());
    }

    @Test
    public void Deuce_2(){
        getPlayerPoint(5,5);
        Assert.assertEquals("Deuce",tennisSet.printScore());
    }

    @Test
    public void Joseph_Adv(){
        getPlayerPoint(5,4);
        Assert.assertEquals("Joseph Adv",tennisSet.printScore());
    }

    @Test
    public void Joseph_Win_2(){
        getPlayerPoint(6,4);
        Assert.assertEquals("Joseph Win",tennisSet.printScore());
    }

    @Test
    public void _91_Adv(){
        getPlayerPoint(5,6);
        Assert.assertEquals("91 Adv",tennisSet.printScore());
    }


    @Test
    public void _91_Win_2(){
        getPlayerPoint(5,7);
        Assert.assertEquals("91 Win",tennisSet.printScore());
    }





}
