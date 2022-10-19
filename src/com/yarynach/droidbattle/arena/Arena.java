package com.yarynach.droidbattle.arena;
import com.yarynach.droidbattle.droids.Droid;

import java.util.concurrent.TimeUnit;

public class Arena  {
    protected final Droid F;
    protected final Droid S;

    private int round=0;

    public Arena(Droid firstDroid, Droid secondDroid) {
        F = firstDroid;
        S = secondDroid;
    }

    public void start(){
        fight();
        Droid win = winner() ;
        if(win!=null) {
            System.out.println("The winner is " + win.getName());
        }
        else{
            System.out.println("No one win");
        }
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
    protected void atack(Droid atacker, Droid defender){
        defender.getHit(atacker.getDamage());
       // defender.getHit(atacker.getDamage());
    }
    private void fight(){
        do{
            round();
            atack(S,F);
            atack(F,S);
            roundInfo();

        }while(S.isAlive() && F.isAlive());
    }
    protected void round(){
        round++;
        System.out.println("Its round num. "+round);
    }
    protected void roundInfo(){
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
