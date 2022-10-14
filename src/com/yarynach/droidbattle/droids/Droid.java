package com.yarynach.droidbattle.droids;

public class Droid {
    private String name;
    private int health;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Droid(String name, int health, int damage) {
        this.name = "Droid" + name;
        this.health = health;
        this.damage = damage;
    }

    public void getHit( int damage){
        this.health-=damage;
    }
    public boolean isAlive(){
        return (health>0);
    }
}
