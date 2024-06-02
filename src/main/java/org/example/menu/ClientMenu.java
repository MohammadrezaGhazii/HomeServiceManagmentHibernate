package org.example.menu;

import org.example.model.Client;
import org.example.service.client.ClientService;
import org.example.utilities.ApplicationContext;
import org.example.utilities.Validation;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class ClientMenu {
    Scanner scanner = new Scanner(System.in);
    ClientService clientService = ApplicationContext.getClientService();

    public void clientMenu(String email) {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** CLIENT MENU ***");
            System.out.println("1-Add new order");
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
        Optional<Client> clientOptional = clientService.searchWithEmail(email);
        if (clientOptional.isPresent()){
            System.out.println("!!! You Are Changing Your PASSWORD !!!");
            String password = getValidPassword();

            Client client = clientOptional.get();
            client.setPassword(password);
            clientService.saveOrUpdate(client);
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
