package com.yarynach.droidbattle.arena;
import com.yarynach.droidbattle.droids.Droid;

import java.util.concurrent.TimeUnit;

public class Arena  {
    private final Droid F;
    private final Droid S;
    private int round=0;

    public Arena(Droid firstDroid, Droid secondDroid) {
        F = firstDroid;
        S = secondDroid;
    }

    public Droid start(){
        fight();
        return winner();
    }
    private Droid winner(){
        Droid win = null;
        if (F.isAlive()){
            win = F;
        }
        else if (S.isAlive()){
            win = S;
        }
        return win;
    }
    private void fight(){
        do{
            round();
            S.getHit(F.getDamage());
            F.getHit(S.getDamage());
            roundInfo();

        }while(S.isAlive() && F.isAlive());
    }
    private void round(){
        round++;
        System.out.println("Its round num. "+round);
    }
    private void roundInfo(){
        try {
    System.out.println("The health of first is " + F.getHealth() + "xp");
    System.out.println("The health of second is " + S.getHealth() + "xp");
    System.out.println("...");
    Thread.sleep(700);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

}
