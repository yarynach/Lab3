package com.yarynach.droidbattle;

import com.yarynach.droidbattle.menu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        MainMenu menu = new MainMenu();

        while(true){
            System.out.println("""
                    Available commands:
                    1.Create droid
                    2.Start 1vs1 
                    3.Show created droids
                    4.Start team fight
                    5.Show recent battle
                    6.Exit
                    """);
            String command = scan.next();
            menu.execute(command);
        }
    }
}
