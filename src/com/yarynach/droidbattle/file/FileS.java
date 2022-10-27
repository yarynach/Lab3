package com.yarynach.droidbattle.file;

import java.io.*;
import java.util.Scanner;

public  class FileS {

    private static PrintStream f=createFile();

    public static PrintStream createFile() {
        try {
            return new PrintStream("src/battle.txt");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            System.exit(1);
            return null;
        }
    }
    public void closeFiel(){
            f.close();
    }
    public static void print(String me){
            f.println(me);
            System.out.println(me);
    }
    public void printAll(){
        Scanner fileScan = null;
        try {
            fileScan = new Scanner(new File("src/battle.txt"));
        } catch (Exception e) {
            System.out.println("Не вдалося відкрити файл!");
            System.exit(1);
        }
        while (fileScan.hasNext())
            System.out.println(fileScan.nextLine());
        fileScan.close();
    }

}

