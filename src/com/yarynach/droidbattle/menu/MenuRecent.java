package com.yarynach.droidbattle.menu;

import com.yarynach.droidbattle.file.FileS;

public class MenuRecent implements MenuItem {
    @Override
    public void execute() {
        new FileS().printAll();
    }
}
