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
    }


