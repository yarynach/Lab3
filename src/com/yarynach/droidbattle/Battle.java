package com.yarynach.droidbattle;

import com.yarynach.droidbattle.droids.*;
import com.yarynach.droidbattle.arena.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Battle {

    private static final ArrayList<Droid> droids = new ArrayList<>();

    private Droid createDroid(){
        Scanner scan = new Scanner(System.in);
        System.out.println("""
                Choose the droid you want to create:
                1.Your own droid
                2.Droid Tank
                3.Droid Healer
                4.Droid Warrior""");
        int num = scan.nextInt();
        System.out.println("Enter the name of your droid");
        scan.nextLine();
        String name = scan.nextLine();
        switch(num){
            case 1:
                System.out.println("Enter the amount of health of your droid");
                int health = scan.nextInt();
                System.out.println("Enter the amount of damage of your droid");
                int damage = scan.nextInt();
                return new Droid(name,health,damage);
            case 2:
                return new Tank(name);
            case 3:
                return new Healer(name);
            case 4:
                return new Warrior(name);
            default:
                System.out.println("Incorrect command");
                return  createDroid();

        }
    }
    public void addDroid(){
        droids.add(createDroid());
        System.out.println("Added!");
    }
    public void showDroids(){
        //droids.forEach((n)->System.out.println(n));
        int n=0;
        for(Droid d: droids){
            n++;
            System.out.println(n+"."+d);
        }
    }
    public void battle(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of droid you want to join this battle:");
        showDroids();
        Droid d1 = droids.get(scan.nextInt()-1);
        System.out.println("Droid "+d1.getName()+" joins the game!");
        Droid d2 = droids.get(scan.nextInt()-1);
        Arena arena = new Arena(d1,d2);
        arena.start();

    }
    public void battleTeam() {
        Droid[] team1 = new Droid[2];
        Droid[] team2 = new Droid[2];
        team1[0] = new Droid("Oxana", 40, 10);
        team1[1] = new Droid("Oxana", 41, 10);
        team2[0] = new Droid("Oxana", 120, 10);
        team2[1] = new Droid("Oxana", 20, 10);
        TeamArena arena = new TeamArena(team1[0],team1[1],team2[0],team2[1]);
        arena.start();
    }

}
