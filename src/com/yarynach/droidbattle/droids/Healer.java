package com.yarynach.droidbattle.droids;

import java.util.Random;

public class Healer extends Droid {
    public Healer(String name) {
        super("Healer "+name,120,16);
    }
    @Override
    public void getHit(int damage) {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            setHealth(getHealth()+(int)(damage*0.3));
            return;
            }
        setHealth(getHealth()-damage);
        }

    @Override
    public void interact(Droid d) {
        super.interact(d);
        Random rand = new Random();
        if (rand.nextBoolean()) {
            d.setHealth((int)(d.getHealth()+d.getHealth()*0.19));
        }
    }

    @Override
    public String toString() {
        return "Droid Healer "+ getName()
                + " Health:"+ getHealth()
                + " Damage:" + getDamage()
                +" Superpower - healing";
    }
}


