package org.example.menu;

import org.example.model.Admin;
import org.example.service.admin.AdminService;
import org.example.utilities.ApplicationContext;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    final AdminService adminService = ApplicationContext.getAdminService();
    public void mainMenu() {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** MAIN MENU ***");
            System.out.println("1-Admin Sign in - ورود مدیر");
            System.out.println("2-Specialist Sign up - ثبت نام متخصص");
            System.out.println("3-Specialist Sign in - ورود متخصص");
            System.out.println("4-Customer Sign up - ثبت نام مشتری");
            System.out.println("5-Customer Sign up - ورود مشتری");
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
                case 1 -> adminSignIn();
                case 2 -> {}
                case 0 -> System.out.println("Bye Bye");
                default -> System.out.println("Wrong input");
            }
        }
    }
    private String adminSignIn(){
        String email = "";
        String password = "";
        while (true){
            System.out.println("Enter your Email :");
            email = Inputs.getString();
            System.out.println("Enter your password :");
            password = Inputs.getString();

            Optional<Admin> admin = adminService.adminSignIn(email,password);

            if (admin.isPresent()){
                String name = admin.get().getFirstName();
                System.out.println("Welcome " + name);

                return email;
            }
            else
                System.out.println("Email or password is invalid");
        }
    }
}
