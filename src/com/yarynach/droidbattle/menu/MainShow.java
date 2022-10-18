package com.yarynach.droidbattle.menu;
import com.yarynach.droidbattle.Battle;

public class MainShow implements MenuItem {
    @Override
    public void execute() {
        new Battle().showDroids();
    }
}
