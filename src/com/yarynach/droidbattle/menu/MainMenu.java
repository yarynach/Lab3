package com.yarynach.droidbattle.menu;
import java.util.Map;
import java.util.LinkedHashMap;



public class MainMenu {
    private Map<String,MenuItem> menuItems;
    public MainMenu(){
        menuItems = new LinkedHashMap<>();
        menuItems.put("2", new MenuStart());
        menuItems.put("1", new MainCreate());
        menuItems.put("3", new MainShow());
        menuItems.put("4", new MenuTeam());
        menuItems.put("5", new MenuRecent());
        menuItems.put("6", new MenuExit());
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


