package org.example.menu;

import org.example.enums.OrderSituation;
import org.example.model.Client;
import org.example.model.Order;
import org.example.model.Service;
import org.example.model.SubService;
import org.example.service.client.ClientService;
import org.example.service.order.OrderService;
import org.example.service.service.ServiceService;
import org.example.service.subService.SubServiceService;
import org.example.utilities.ApplicationContext;
import org.example.utilities.Validation;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ClientMenu {
    Scanner scanner = new Scanner(System.in);
    ClientService clientService = ApplicationContext.getClientService();
    SubServiceService subServiceService = ApplicationContext.getSubServiceService();
    ServiceService serviceService = ApplicationContext.getServiceService();
    OrderService orderService = ApplicationContext.getOrderService();

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
                case 1 -> addOrder(email);
                case 2 -> changePassword(email);
                case 0 -> System.out.println("Returned to previous menu");
                default -> System.out.println("Wrong input");
            }
        }
    }

    private void addOrder(String email) {
        Optional<Client> clientOptional = clientService.searchWithEmail(email);
        Client client = null;
        if (clientOptional.isPresent()) {
            client = clientOptional.get();
        }
        listService();
        Long idService = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter ID Service that you need : ");
                idService = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<Service> byIdServiceOptional = serviceService.findById(idService);
        if (byIdServiceOptional.isPresent()) {
            Service service = byIdServiceOptional.get();
            List<SubService> subServices = subServiceService.searchWithIdService(service);
            System.out.println("list of sub services " + service.getName() + " :");
            for (SubService subService : subServices) {
                System.out.println("| Id Sub Service : " + subService.getId() +
                        " | Sub Service name : " + subService.getName() +
                        " | Sub Service description : " + subService.getDescription());
            }
        }

        Long idSubService = 0L;
        boolean validInput1 = false;

        while (!validInput1) {
            try {
                System.out.println("Enter ID Service that you need : ");
                idSubService = Inputs.getLongNum();
                validInput1 = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<SubService> byIdSubService = subServiceService.findById(idSubService);
        if (byIdSubService.isPresent()) {
            SubService subService = byIdSubService.get();

            System.out.println("Enter your address :");
            String address = Inputs.getString();

            System.out.println("Enter your explain your needs :");
            String explain = Inputs.getString();

            boolean validInput2 = false;
            LocalDate requestedDate = null;
            LocalTime requestedTime = null;

            while (!validInput2) {
                try {
                    System.out.println("Enter your requested Date : ");
                    requestedDate = Inputs.getLocalDate();
                    System.out.println("Enter your requested Time : ");
                    requestedTime = Inputs.getLocalTime();
                    validInput2 = true;
                } catch (InputMismatchException e) {
                    System.out.println("Input should be number !!!");
                    scanner.next();
                }
            }

            Order order = Order.builder()
                    .address(address)
                    .explain(explain)
                    .orderDate(LocalDate.now())
                    .orderSituation(OrderSituation.WAIT_FOR_SPECIALIST_OFFER)
                    .requestedDate(requestedDate)
                    .requestedTime(requestedTime)
                    .client(client)
                    .subService(subService)
                    .build();
            orderService.saveOrUpdate(order);
        }
    }

    private void listService() {
        List<Service> allServices = serviceService.findAll();
        System.out.println("List Services :");
        for (Service allService : allServices) {
            System.out.println("| ID Service : " + allService.getId() +
                    " | Name Service : " + allService.getName());
        }
    }

    private void changePassword(String email) {
        List<Service> allServices = serviceService.findAll();
        System.out.println("List Services :");
        for (Service allService : allServices) {
            System.out.println("| ID Service : " + allService.getId() +
                    " | Name Service : " + allService.getName());
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
