package org.example;

import org.example.conncetion.SessionFactorySingleton;
import org.example.menu.MainMenu;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();
    }
}