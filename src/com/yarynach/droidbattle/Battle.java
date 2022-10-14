package com.yarynach.droidbattle;

import com.yarynach.droidbattle.droids.*;
import com.yarynach.droidbattle.arena.*;

public class Battle {
    public void battle(){
        Droid d1 = new Tank("Monster");
        Droid d2 = new Healer("Yaryna");
        Arena arena = new Arena(d1,d2);
        Droid winner =arena.start();
        System.out.println("The winner is "+ winner.getName());
    }
}
