package com.company;

public class GameStart {
    Hunter hunter;
    Monster m1,m2,m3,m4,m5;

    public GameStart(){
        hunter = new Hunter("小何佩","大冰棒");
        m1 = new Monster(3);
        m2 = new Monster(3);
        m3 = new Monster(3);
        m4 = new Monster(2);
        m5 = new Monster(4);
    }


    public void start(){

        while(hunter.isLive && (m1.isLive || m2.isLive || m3.isLive || m4.isLive || m5.isLive)){
            System.out.println("------------------对手寻找中---------------------");
            /**让程序休息3秒钟**/
            try{
                Thread.sleep(3000);
            }
            catch(Exception e)
            {}
            int ran = GameUtil.randomaRange(1,6);     // 产生随机数，随机寻找僵尸进行战斗
            switch(ran){
                case 1: hunter.fight(m1);   break;
                case 2: hunter.fight(m2);   break;
                case 3: hunter.fight(m3);   break;
                case 4: hunter.fight(m4);   break;
                case 5: hunter.fight(m5);   break;
                default:System.out.println("拜托啊！你要找个正常一点的战斗");     break;   //rand到不存在的僵尸;
            }
        }
        end();
    }


    public void end(){
        if(hunter.isLive == true){
            System.out.println("恭喜你！过关啦");
        }else{
            System.out.println("哈哈哈哈哈哈，被僵尸打死了吧");
        }
    }
}
