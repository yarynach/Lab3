package com.yarynach.droidbattle;

import com.yarynach.droidbattle.menu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        MainMenu menu = new MainMenu();
        System.out.println("Input command");
        while(true){
            String command = scan.next();
            menu.execute(command);
        }
    }
}
