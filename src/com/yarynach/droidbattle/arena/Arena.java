package com.yarynach.droidbattle.arena;
import com.yarynach.droidbattle.droids.Droid;

public class Arena {
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
        if (F.isAlive()){
            return F;
        }
        else if (S.isAlive()){
            return S;
        }
        else if (S.isAlive()==F.isAlive()){
            System.out.println("No one win");
            return null;
        }
        return null;
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

        System.out.println("The health of first is " + F.getHealth() + "xp");
        System.out.println("The health of second is " + S.getHealth() + "xp");
    }
}
