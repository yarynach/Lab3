package com.yarynach.droidbattle.droids;

import java.util.Random;
import com.yarynach.droidbattle.Colors;
public class Warrior extends Droid{

    private int CriticalHit = 40;
    private int counter=0;

    public Warrior(String name) {
        super("Warrior  "+name,150,21);
    }

    public int getCriticalHit() {
        return CriticalHit;
    }

    public void setCriticalHit(int criticalHit) {
        CriticalHit = criticalHit;
    }
    private void HitC(){
            setDamage(getDamage()+getCriticalHit());
    }
    private void CounterCheck(){
        if (counter==1){
            HitC();
            System.out.println(Colors.ANSI_RED_FONT+"CRITICAL!"+Colors.ANSI_RESET);
            counter++;
        } else if (counter==2) {
            setDamage(getDamage()-getCriticalHit());
            counter++;
        }
    }
    @Override
    public void getHit(int damage) {
        super.getHit(damage);

        Random rand = new Random();
        int rn = rand.nextInt(11);
        if (rn==9){
            counter=1;
        }
        CounterCheck();
        System.out.println(Colors.ANSI_CYAN_FONT+"Warrior damage is " + getDamage()+Colors.ANSI_RESET);

    }
}
