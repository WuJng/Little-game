package com.company;

public class GameUtil {
    public static int randomaRange(int start,int end){
        return (int)(Math.random()*(end-start)+start);
    }

    public static boolean hidden(int agile,int hideRate){
        int sucRate = agile*hideRate/100;
        int ran = GameUtil.randomaRange(1,101);
        if(ran<sucRate){
            return true;
        }
        return false;
    }

    static int lostBasicLife = 10;

    public static int calLostLife(int attack,int defend){
        int lostLife = attack-defend;
        int rel = 0;
        if(lostLife<=0){
            rel = lostBasicLife;
        }else{
            rel = (lostLife+lostBasicLife);
        }
        return rel;
    }


}
