package com.yarynach.droidbattle.menu;

public class MenuExit implements MenuItem{
    @Override
    public void execute() {
        System.out.println("End");
        System.exit(0);
    }
}

