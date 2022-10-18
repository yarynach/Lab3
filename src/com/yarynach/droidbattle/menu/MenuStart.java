package com.yarynach.droidbattle.menu;

import com.yarynach.droidbattle.Battle;

public class MenuStart implements MenuItem {
    @Override
    public void execute() {
       new Battle().battle();
    }
}
