package com.yarynach.droidbattle;

import com.yarynach.droidbattle.droids.Droid;
import com.yarynach.droidbattle.arena.*;

public class Battle {
    public void battle(){
        Droid d1 = new Droid("Monster",100,12);
        Droid d2 = new Droid("Horse",  130,10);
        Arena arena = new Arena(d1,d2);
        Droid winner =arena.start();
        System.out.println("The winner is "+ winner.getName());
    }
}
