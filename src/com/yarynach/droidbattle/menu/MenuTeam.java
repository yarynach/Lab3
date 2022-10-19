package com.yarynach.droidbattle.menu;

import com.yarynach.droidbattle.Battle;

public class MenuTeam implements MenuItem{
    @Override
    public void execute() {
        new Battle().battleTeam();
    }
}
