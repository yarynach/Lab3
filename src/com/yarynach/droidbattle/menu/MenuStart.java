package com.yarynach.droidbattle.menu;

import com.yarynach.droidbattle.Battle;
import com.yarynach.droidbattle.file.FileS;

public class MenuStart implements MenuItem {
    @Override
    public void execute() {
        new Battle().battle();
    }
}
