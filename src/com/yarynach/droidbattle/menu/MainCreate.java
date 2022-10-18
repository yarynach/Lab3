package com.yarynach.droidbattle.menu;
import com.yarynach.droidbattle.Battle;

public class MainCreate implements MenuItem{
    @Override
    public void execute() {
        new Battle().addDroid();
    }
}
