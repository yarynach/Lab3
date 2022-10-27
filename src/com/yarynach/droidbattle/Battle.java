package com.yarynach.droidbattle;

import com.yarynach.droidbattle.arena.Arena;
import com.yarynach.droidbattle.arena.TeamArena;
import com.yarynach.droidbattle.droids.Droid;
import com.yarynach.droidbattle.droids.Healer;
import com.yarynach.droidbattle.droids.Tank;
import com.yarynach.droidbattle.droids.Warrior;
import com.yarynach.droidbattle.file.FileS;

import java.util.ArrayList;
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
        if(droids.size()<2){
            System.out.println("You should create more droids!");
            return;
        }
        final FileS f = new FileS();
        f.createFile();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter index of droid you want to join this battle:");
        showDroids();
        Droid d1 = droids.get(scan.nextInt()-1);
        droids.remove(d1);
        showDroids();
        System.out.println("Droid "+d1.getName()+" joins the game!");
        Droid d2 = droids.get(scan.nextInt()-1);
        droids.remove(d2);
        Arena arena = new Arena(d1,d2);
        arena.start();
        f.closeFiel();

    }
    public void battleTeam() {
        if(droids.size()<4){
            System.out.println("You should create more droids!");
            return;
        }
        Scanner scan = new Scanner(System.in);

        Droid[] team1 = new Droid[2];
        Droid[] team2 = new Droid[2];
        System.out.println("Enter index of droid you want to join team 1");
        showDroids();
        team1[0] = droids.get(scan.nextInt()-1);
        droids.remove(team1[0]);
        showDroids();
        team1[1] = droids.get(scan.nextInt()-1);
        droids.remove(team1[1]);
        showDroids();
        System.out.println("Team 1: "+team1[0].getName()+team1[1].getName()+" join the game!");
        System.out.println("Enter index of droid you want to join team 2");
        team2[0] = droids.get(scan.nextInt()-1);
        droids.remove(team2[0]);
        showDroids();
        team2[1] = droids.get(scan.nextInt()-1);
        droids.remove(team2[1]);
        System.out.println("Team 2: "+team2[0].getName()+team2[1].getName()+" join the game!");
        TeamArena arena = new TeamArena(team1[0],team1[1],team2[0],team2[1]);
        arena.start();
    }

}
