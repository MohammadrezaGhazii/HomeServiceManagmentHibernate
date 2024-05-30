package org.example.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ClientMenu {
    Scanner scanner = new Scanner(System.in);
    public void clientMenu() {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** ADMIN MENU ***");
            System.out.println("1-Add new service");
            System.out.println("2-Add new sub-service");
            System.out.println("3-Add new sub-service");
            System.out.println("4-Add new sub-service");
            System.out.println("0-Exit");
            System.out.println();
            try {
                System.out.println("Enter a number:");
                numberInput = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }

            switch (numberInput) {
                case 1 -> {}
                case 2 -> {}
                case 0 -> System.out.println("Returned to previous menu");
                default -> System.out.println("Wrong input");
            }
        }
    }
}
