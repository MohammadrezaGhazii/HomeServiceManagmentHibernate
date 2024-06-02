package org.example.menu;

import org.example.enums.SpecialistSituation;
import org.example.model.*;
import org.example.service.admin.AdminService;
import org.example.service.client.ClientService;
import org.example.service.creditClient.CreditClientService;
import org.example.service.creditSpecialist.CreditSpecialistService;
import org.example.service.specialist.SpecialistService;
import org.example.utilities.ApplicationContext;
import org.example.utilities.Validation;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);
    AdminMenu adminMenu = new AdminMenu();
    ClientMenu clientMenu = new ClientMenu();
    SpecialistMenu specialistMenu = new SpecialistMenu();
    final AdminService adminService = ApplicationContext.getAdminService();
    final ClientService clientService = ApplicationContext.getClientService();
    final CreditClientService creditClientService = ApplicationContext.getCreditClientService();
    final SpecialistService specialistService = ApplicationContext.getSpecialistService();
    final CreditSpecialistService creditSpecialistService = ApplicationContext.getCreditSpecialistService();

    public void mainMenu() {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** MAIN MENU ***");
            System.out.println("1-Admin Sign in - ورود مدیر");
            System.out.println("2-Specialist Sign up - ثبت نام متخصص");
            System.out.println("3-Specialist Sign in - ورود متخصص");
            System.out.println("4-Customer Sign up - ثبت نام مشتری");
            System.out.println("5-Customer Sign in - ورود مشتری");
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
                    adminSignIn();
                    adminMenu.adminMenu();
                }
                case 2 -> specialistSignUp();
                case 3 -> {
                    String email = specialistSignIn();
                    specialistMenu.specialistMenu(email);
                }
                case 4 -> clientSignUp();
                case 5 -> {
                    String email = clientSignIn();
                    clientMenu.clientMenu(email);
                }
                case 0 -> System.out.println("Bye Bye");
                default -> System.out.println("Wrong input");
            }
        }
    }

    private String adminSignIn() {
        String email = "";
        String password = "";
        while (true) {
            System.out.println("Enter your Email :");
            email = Inputs.getString();
            System.out.println("Enter your password :");
            password = Inputs.getString();

            Optional<Admin> admin = adminService.adminSignIn(email, password);

            if (admin.isPresent()) {
                String name = admin.get().getFirstName();
                System.out.println("Welcome " + name);

                return email;
            } else
                System.out.println("Email or password is invalid");
        }
    }

    private void specialistSignUp() {
        System.out.println("** Register as Specialist **");
        System.out.println("Please enter your firstname :");
        String name = Inputs.getString();

        System.out.println("Please enter your lastname :");
        String lastname = Inputs.getString();

        System.out.println("Please enter your E-Mail :");
        String email = Inputs.getString();
        Optional<Specialist> specialistEmail = specialistService.searchWithEmail(email);
        if (specialistEmail.isPresent()) {
            System.out.println("This Email SignUp Before !!! -Try another Email or go to SignIn menu");
            mainMenu();
        } else {
            String password = getValidPassword();

            System.out.println("Please enter your phone number :");
            String phoneNumber = Inputs.getString();

            LocalDate localDate = LocalDate.now();

            double score = 0;

            SpecialistSituation specialistSituation = SpecialistSituation.NEW_JOINER;

            Specialist specialist = Specialist.builder()
                    .firstName(name)
                    .lastName(lastname)
                    .email(email)
                    .password(password)
                    .phoneNumber(phoneNumber)
                    .registerDate(localDate)
                    .score(score)
                    .situation(specialistSituation)
                    .build();
            specialistService.saveOrUpdate(specialist);

            crediteSpecialist(specialist);
        }
    }

    private void crediteSpecialist(Specialist specialist) {
        CreditSpecialist creditSpecialist = CreditSpecialist.builder()
                .inventory(0D)
                .specialist(specialist)
                .build();
        creditSpecialistService.saveOrUpdate(creditSpecialist);
    }

    private String specialistSignIn() {
        String email = "";
        String password = "";
        while (true) {
            System.out.println("Enter your Email :");
            email = Inputs.getString();
            System.out.println("Enter your password :");
            password = Inputs.getString();

            Optional<Specialist> specialist = specialistService.specialistSignIn(email, password);

            if (specialist.isPresent()) {
                String name = specialist.get().getFirstName();
                System.out.println("Welcome " + name);

                return email;
            } else
                System.out.println("Email or password is invalid");
        }
    }

    private void clientSignUp() {
        System.out.println("** Register as Client **");
        System.out.println("Please enter your firstname :");
        String name = Inputs.getString();

        System.out.println("Please enter your lastname :");
        String lastname = Inputs.getString();

        System.out.println("Please enter your E-Mail :");
        String email = Inputs.getString();
        Optional<Client> clientEmail = clientService.searchWithEmail(email);
        if (clientEmail.isPresent()) {
            System.out.println("This Email SignUp Before !!! -Try another Email or go to SignIn menu");
            mainMenu();
        } else {
            String password = getValidPassword();

            System.out.println("Please enter your phone number :");
            String phoneNumber = Inputs.getString();

            LocalDate localDate = LocalDate.now();

            Client client = Client.builder()
                    .firstName(name)
                    .lastName(lastname)
                    .email(email)
                    .password(password)
                    .phoneNumber(phoneNumber)
                    .registerDate(localDate)
                    .build();
            clientService.saveOrUpdate(client);

            createCreditClient(client);
        }
    }

    private void createCreditClient(Client client) {
        CreditClient creditClient = CreditClient.builder()
                .client(client)
                .inventory(0)
                .build();
        creditClientService.saveOrUpdate(creditClient);
    }

    private String clientSignIn() {
        String email = "";
        String password = "";
        while (true) {
            System.out.println("Enter your Email :");
            email = Inputs.getString();
            System.out.println("Enter your password :");
            password = Inputs.getString();

            Optional<Client> client = clientService.clientSignIn(email, password);

            if (client.isPresent()) {
                String name = client.get().getFirstName();
                System.out.println("Welcome " + name);

                return email;
            } else
                System.out.println("Email or password is invalid");
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
