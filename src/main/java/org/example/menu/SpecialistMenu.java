package org.example.menu;

import org.example.model.Client;
import org.example.model.Specialist;
import org.example.service.specialist.SpecialistService;
import org.example.utilities.ApplicationContext;
import org.example.utilities.Validation;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class SpecialistMenu {
    Scanner scanner = new Scanner(System.in);
    SpecialistService specialistService = ApplicationContext.getSpecialistService();

    public void specialistMenu(String email) {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** Specialist MENU ***");
            System.out.println("1-");
            System.out.println("2-Change your password");
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
                case 1 -> {
                }
                case 2 -> changePassword(email);
                case 0 -> System.out.println("Returned to previous menu");
                default -> System.out.println("Wrong input");
            }
        }
    }
    private void changePassword(String email){
        Optional<Specialist> specialistOptional = specialistService.searchWithEmail(email);
        if (specialistOptional.isPresent()){
            System.out.println("!!! You Are Changing Your PASSWORD !!!");
            String password = getValidPassword();

            Specialist specialist = specialistOptional.get();
            specialist.setPassword(password);
            specialistService.saveOrUpdate(specialist);
        }
    }
    public String getValidPassword() {
        String password;
        while (true) {
            System.out.println("Please enter your password :");
            password = scanner.nextLine();
            if (Validation.isPasswordValid(password))
                break;
            else
                System.out.println("This " + password + " is not strong , try again");
        }
        return password;
    }
}
