package com.yarynach.droidbattle;

import com.yarynach.droidbattle.droids.*;
import com.yarynach.droidbattle.arena.*;

public class Battle {
    public void battle(){
        Droid d1 = new Tank("Monster");
        Droid d2 = new Warrior("Yaryna");
        Arena arena = new Arena(d1,d2);
        Droid winner =arena.start();
        System.out.println("The winner is "+ winner.getName());
    }
    public void battleGroup(){
        Droid[] team1 = new Droid[2];
        Droid[] team2 = new Droid[2];
        team1[0] = new Tank("Monster");
        team1[1] = new Warrior("Monster2");
        team2[0]= new Droid("Oxana",200,16);
        team2[1]= new Healer("Heart");
        do{


        }while(aliveTeam(team1)||aliveTeam(team2));
    }
    private boolean aliveTeam(Droid[] team){
        return (team[0].isAlive()&&team[1].isAlive());
    }
}
