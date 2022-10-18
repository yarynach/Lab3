package com.yarynach.droidbattle.droids;

import java.util.Random;
import com.yarynach.droidbattle.Colors;

public class Tank extends Droid {
    private int defence =50;
    private int counter = 0;


    public Tank(String name) {
        super("Tank "+name,150,24);
    }

    public int getDefence() {
        setZero();
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    @Override
    public void getHit(int damage) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            if (defence > 0) {
                System.out.println(Colors.ANSI_BLUE_BACKGROUND +"!!Defence to" + getName()+ "!!" +Colors.ANSI_RESET);
                defence -= damage;
                if (defence<=0){
                    setHealth(getHealth()+defence);
                    defence=0;
                }
                System.out.println("Defence of "+getName()+defence);
                counter++;
                counterCheck();
                return;
            }
        }
        setHealth(getHealth()-damage);
    }
    private void counterCheck(){
        if (counter==2){
            setDamage(getDamage()+3);
            System.out.println(Colors.ANSI_GREEN_FONT + "!MORE DAMAGE TO "+getName()+"!!" + Colors.ANSI_RESET);
            counter=0;
        }
    }
    @Override
    public boolean isAlive() {
        if (getHealth()<=0){ setDefence(0);}
        return (getHealth()>0);
    }
    @Override
    public void setZero() {
        super.setZero();
    }

    @Override
    public String toString() {
        return "Droid Tank "+ getName()
                + " Health:"+ getHealth()
                + " Damage:" + getDamage()
                + " Defence:" + getDefence()
                +" Superpower - more damage";
    }
}
