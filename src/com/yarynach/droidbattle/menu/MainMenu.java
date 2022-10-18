package com.yarynach.droidbattle.menu;
import java.util.Map;
import java.util.LinkedHashMap;



public class MainMenu {
    private Map<String,MenuItem> menuItems;
    public MainMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("info", new MenuInfo());
        menuItems.put("start", new MenuStart());
        menuItems.put("exit", new MenuExit());
    }
    public void execute(String command){
        MenuItem menuItem = menuItems.get(command);
        if (menuItem!=null){
            menuItem.execute();
        } else{
            System.out.println("Incorrect command!");
        }

    }
    }


