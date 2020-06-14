package com.company;

public class Monster {
    int curLife;
    int maxLife;
    String type;
    boolean isLive = true;
    int attack;         //攻击力
    int defend;         //防御力
    int agile;          //敏捷
    int hideRate;       //躲避率

    public Monster(int mt){
        switch(mt){
            case 1: type = "超级丧尸";maxLife = 80; curLife = 80;   attack = 25;defend = 15;    agile = 30;hideRate = 80;   break;
            case 2: type = "变异丧尸";maxLife = 80; curLife = 60;   attack = 28;defend = 10;    agile = 40;hideRate = 70;   break;
            case 3: type = "普通丧尸";maxLife = 80; curLife = 40;   attack = 10;defend = 5;     agile = 30;hideRate = 60;   break;
            case 4: type = "吸血鬼"; maxLife = 80; curLife = 60; attack = 20; defend = 8; agile = 30;hideRate = 60;
        }
    }

    public void injured(Hunter hunter){   //掉血
        //增加躲避的判断
        if(GameUtil.hidden(this.agile,this.hideRate)){
            System.out.println("*********"+type+":略略略，砍不到我");
            show();
            kill(hunter);
            return;
        }

        System.out.println("**********"+type+"又被砍了一刀"+"***********");
        int lostLife = GameUtil.calLostLife(hunter.attack, this.defend);
        curLife-=lostLife;
        if(curLife<0){
            curLife=0;
            died(hunter);
            return;
        }
        show();
        kill(hunter);
    }

    public void died(Hunter hunter){
        this.isLive = false;
        System.out.println("**********"+type+"被砍的四分五裂了"+"**********"+isLive);
        hunter.expAdd(this);    //this
    }
    public void kill(Hunter hunter){
        if(isLive){
            System.out.println("**********>"+type+"冲上去咬了"+hunter.name+"一大口"+"***********");
            hunter.injured(this);
        }else{
            System.out.println("**********"+type+"已经被砍的四分五裂了"+"**********");
        }
    }
    public void show(){
        System.out.println("**********"+type+"  "+"生命值"+curLife+"  "+"生命状态"+isLive+"***************");
    }
}
