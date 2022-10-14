package com.yarynach.droidbattle.droids;

import java.util.Random;

public class Tank extends Droid {
    private int defence =50;
    private int counter = 0;
    public static final String ANSI_BLUE_BACKGROUND ="\u001B[46m";
    public static final String ANSI_GREEN_FONT = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

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
                System.out.println(ANSI_BLUE_BACKGROUND +"!!Defence to" + getName()+ "!!" +ANSI_RESET);
                defence -= damage;
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
            System.out.println(ANSI_GREEN_FONT + "!MORE DAMAGE TO "+getName()+"!!" + ANSI_RESET);
            counter=0;
        }
    }
    @Override
    public boolean isAlive() {
        return (getHealth()>0 || getDefence()>0);
    }
    @Override
    public void setZero() {
        super.setZero();
        if (defence<0){
            defence=0;
        }
    }
}
