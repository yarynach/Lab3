package com.yarynach.droidbattle.arena;

import com.yarynach.droidbattle.droids.Droid;
import com.yarynach.droidbattle.file.FileS;

import static com.yarynach.droidbattle.file.FileS.print;


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
            print("The winner is " + win.getName());
        }
        else{
            print("No one win");
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
        new FileS().closeFiel();
    }
    protected void round(){
        round++;
        print("Its round num. "+round);
    }
    protected void roundInfo(){
        try {
    print("The health of first is " + F.getHealth() + "xp");
    print("The health of second is " + S.getHealth() + "xp");
    print("...");
    Thread.sleep(700);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }



}
