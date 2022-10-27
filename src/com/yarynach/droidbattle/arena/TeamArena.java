package com.yarynach.droidbattle.arena;

import com.yarynach.droidbattle.droids.Droid;


import java.util.Random;

import static com.yarynach.droidbattle.file.FileS.print;

public class TeamArena extends Arena{
    private final Droid F1;
    private final Droid S1;

    public TeamArena(Droid f, Droid f1, Droid s, Droid s1) {
        super(f,s);
        F1= f1;
        S1 = s1;
    }
    public Droid[] formTeam(Droid d, Droid d1){
        return new Droid[] {d,d1};
    }
    private void interractWith(Droid[] team){
        team[0].interact(team[1]);
        team[1].interact(team[0]);
    }

    public void start() {
        Droid[] winner = fight();
        if(winner.length!=0) {
            print("The winner is " + winner[0].getName()+"and"+winner[1].getName());
        }
        else{
            print("No one win");
        }
    }

    @Override
    protected void roundInfo() {
        try {
            print("The health of the first command" + F.getHealth() + "xp and "
                    +F1.getHealth()+ "xp");
            print("The health of the second command" + S.getHealth() + "xp and"
                    +S1.getHealth()+"xp");
            print("...");
            Thread.sleep(700);
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

    }

    protected Droid[] fight() {
        Droid[] team1 = formTeam(F,F1);
        Droid[] team2 = formTeam(S,S1);
        Random rand = new Random();
        boolean b;
        do {
            round();
            for (int i = 0; i < 2; i++) {
                if (isLastAlive(team2)&&team1[i].isAlive()){
                    int in  = team2[0].isAlive()?0:1;
                    team1[i].getHit(team2[in].getDamage());
                    break;
                }else if(isLastAlive(team1)&&isAliveMemberTeam(team2)){
                    team1[i].getHit(team2[0].getDamage()+team2[1].getDamage());
                }else if (team1[i].isAlive()||isAliveMemberTeam(team2)) {
                    if (team2[i].isAlive()) {
                        team1[i].getHit(team2[i].getDamage());
                    } else {
                        int in = team2[0].isAlive() ? 0 : 1;
                        team1[i].getHit(team2[in].getDamage());
                    }
                }
            }
            for (int j=0;j<2;j++){
                if (isLastAlive(team1)&&team2[j].isAlive()){
                    int in  = team1[0].isAlive()?0:1;
                    team2[j].getHit(team1[in].getDamage());
                    break;
                }else if(isLastAlive(team2)&&isAliveMemberTeam(team1)) {
                    team2[j].getHit(team1[0].getDamage() + team1[1].getDamage());
                }else if(team2[j].isAlive()){
                    if(team1[j].isAlive()){
                        team2[j].getHit(team1[j].getDamage());
                    }else{
                        int in  = team1[0].isAlive()?0:1;
                        team2[j].getHit(team1[in].getDamage());
                    }
                }
            }
            if(isAliveMemberTeam(team1)) {
                interractWith(team1);
            }else if(isAliveMemberTeam(team2)) {
                interractWith(team2);
            }
            roundInfo();
        }while(isAliveTeam(team1)&&isAliveTeam(team2));
        if(isAliveTeam(team1)){
            return team1;
        } else if (isAliveTeam(team2)) {
            return team2;
        } else{
            return new Droid[]{};
        }
    }
    private boolean isAliveTeam(Droid[] team){
        return (team[0].isAlive()||team[1].isAlive());
    }
    private boolean isAliveMemberTeam(Droid[] team){
        return (team[0].isAlive()&&team[1].isAlive());
    }
    private boolean isLastAlive(Droid[] team){
        return ((team[0].isAlive()&&!team[1].isAlive())||(team[0].isAlive()&&!team[1].isAlive()));
    }
}
