package org.example.menu;

import org.example.enums.SpecialistSituation;
import org.example.model.FieldSpecialist;
import org.example.model.Service;
import org.example.model.Specialist;
import org.example.model.SubService;
import org.example.service.fieldSpecialist.FieldSpecialistService;
import org.example.service.service.ServiceService;
import org.example.service.specialist.SpecialistService;
import org.example.service.subService.SubServiceService;
import org.example.utilities.ApplicationContext;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class AdminMenu {
    Scanner scanner = new Scanner(System.in);
    ServiceService serviceService = ApplicationContext.getServiceService();
    SubServiceService subServiceService = ApplicationContext.getSubServiceService();
    SpecialistService specialistService = ApplicationContext.getSpecialistService();
    FieldSpecialistService fieldSpecialistService = ApplicationContext.getFieldSpecialistService();

    public void adminMenu() {
        int numberInput = -1;
        while (numberInput != 0) {
            System.out.println("*** ADMIN MENU ***");
            System.out.println("1-Add new service");
            System.out.println("2-Update service");
            System.out.println("3-Delete service");
            System.out.println("4-Add new sub-service");
            System.out.println("5-Update sub-service");
            System.out.println("6-Delete sub-service");
            System.out.println("7-List Services");
            System.out.println("8-List Sub Services");
            System.out.println("9-Confirm Specialist ");
            System.out.println("10-Add field Specialist");
            System.out.println("11-Delete field Specialist");
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
                case 1 -> addService();
                case 2 -> updateService();
                case 3 -> deleteService();
                case 4 -> addSubService();
                case 5 -> updateSubService();
                case 6 -> deleteSubService();
                case 7 -> listService();
                case 8 -> listSubService();
                case 9 -> approveSpecialist();
                case 10 -> addSpecialistField();
                case 11 -> deleteFieldSpecialist();
                case 0 -> System.out.println("Returned to previous menu");
                default -> System.out.println("Wrong input");
            }
        }
    }

    private void addService() {
        System.out.println("** Add Service **");
        System.out.println("Please enter service name :");
        String name = Inputs.getString();

        Service service = Service.builder()
                .name(name)
                .build();
        serviceService.saveOrUpdate(service);
    }

    private void updateService() {
        System.out.println("** Update Service **");
        listService();

        Long id = 0L;
        String name = "";
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please enter service ID :");
                id = Inputs.getLongNum();
                System.out.println("Please enter service name :");
                name = Inputs.getString();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<Service> byId = serviceService.findById(id);
        if (byId.isPresent()) {
            Service service = byId.get();
            service.setName(name);
            serviceService.saveOrUpdate(service);
        }
    }

    public void deleteService() {
        System.out.println("** Delete Service **");
        listService();
        Long id = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please enter service ID :");
                id = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }
        Optional<Service> byId = serviceService.findById(id);
        if (byId.isPresent()) {
            serviceService.deleteById(id);
        }
    }

    public void addSubService() {
        System.out.println("** Add Sub Service **");
        String name = "";
        String description = "";
        double basePrice = 0D;
        long idService = 0L;
        Service service;
        boolean validInput = false;

        listService();

        while (!validInput) {
            try {
                System.out.println("Please enter Sub Service name :");
                name = Inputs.getString();
                if (subServiceService.searchWithName(name).isPresent()) {
                    System.out.println("This name is Exist");
                    adminMenu();
                } else {
                    System.out.println("Please enter Sub Service description :");
                    description = Inputs.getString();
                    System.out.println("Please enter Sub Service base price :");
                    basePrice = Inputs.getDoubleNum();
                    System.out.println("Please enter service ID :");
                    idService = Inputs.getLongNum();
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<Service> serviceById = serviceService.findById(idService);
        if (serviceById.isPresent()) {
            service = serviceById.get();
            SubService subService = SubService.builder()
                    .name(name)
                    .description(description)
                    .basePrice(basePrice)
                    .service(service)
                    .build();
            subServiceService.saveOrUpdate(subService);
        }
    }

    public void updateSubService() {
        System.out.println("** Update Sub Service **");
        listSubService();

        long id = 0L;
        String name = "";
        String description = "";
        double basePrice = 0D;
        long idService = 0L;
        Service service;
        boolean validInput = false;

        listService();

        while (!validInput) {
            try {
                System.out.println("Please enter Sub Service ID");
                id = Inputs.getLongNum();
                System.out.println("Please enter Sub Service name :");
                name = Inputs.getString();
                if (subServiceService.searchWithName(name).isPresent()) {
                    System.out.println("This name is Exist");
                    adminMenu();
                } else {
                    System.out.println("Please enter Sub Service description :");
                    description = Inputs.getString();
                    System.out.println("Please enter Sub Service base price :");
                    basePrice = Inputs.getDoubleNum();
                    System.out.println("Please enter service ID :");
                    idService = Inputs.getLongNum();
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }

            Optional<Service> byIdService = serviceService.findById(idService);
            if (byIdService.isPresent()) {
                service = byIdService.get();
                Optional<SubService> byId = subServiceService.findById(id);
                if (byId.isPresent()) {
                    SubService subService = byId.get();
                    subService.setName(name);
                    subService.setDescription(description);
                    subService.setBasePrice(basePrice);
                    subService.setService(service);

                    subServiceService.saveOrUpdate(subService);
                }
            }
        }
    }

    public void deleteSubService() {
        System.out.println("** Delete Sub Service **");
        listSubService();
        Long id = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Please enter sub service ID :");
                id = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }
        Optional<SubService> byId = subServiceService.findById(id);
        if (byId.isPresent()) {
            subServiceService.deleteById(id);
        }
    }

    private void listSubService() {
        List<SubService> allSubServices = subServiceService.findAll();
        System.out.println("List Sub Services :");
        for (SubService allSubService : allSubServices) {
            System.out.println("| Id Sub Service : " + allSubService.getId() +
                    " | Sub Service name : " + allSubService.getName() +
                    " | Sub Service description : " + allSubService.getDescription() +
                    " | Service name : " + allSubService.getService().getName());
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

    private void approveSpecialist() {
        listSpecialistNewJoiner();

        Long idSpecialist = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter ID Specialist to change him/her Situation : ");
                idSpecialist = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<Specialist> byIdSpecialist = specialistService.findById(idSpecialist);
        if (byIdSpecialist.isPresent()) {
            Specialist specialist = byIdSpecialist.get();
            specialist.setSituation(SpecialistSituation.APPROVED);
            specialistService.saveOrUpdate(specialist);
        } else {
            System.out.println("This ID is not avaible");
            adminMenu();
        }
    }

    private void addSpecialistField() {
        listSpecialistApproved();
        listSubService();

        Long idSpecialist = 0L;
        Long idSubService = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter ID Specialist to change him/her Situation : ");
                idSpecialist = Inputs.getLongNum();
                System.out.println("Enter ID SubService that Specialist has skill in it : ");
                idSubService = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }
        }

        Optional<Specialist> byIdSpecialist = specialistService.findById(idSpecialist);
        Optional<SubService> byIdSubService = subServiceService.findById(idSubService);
        if (byIdSpecialist.isPresent() && byIdSubService.isPresent()) {
            Specialist specialist = byIdSpecialist.get();
            SubService subService = byIdSubService.get();

            FieldSpecialist fieldSpecialist = FieldSpecialist.builder()
                    .specialist(specialist)
                    .subService(subService)
                    .build();
            fieldSpecialistService.saveOrUpdate(fieldSpecialist);
        } else {
            System.out.println("Some thing is wrong !!!");
            adminMenu();
        }
    }

    private void deleteFieldSpecialist() {
        List<FieldSpecialist> all = fieldSpecialistService.findAll();
        System.out.println("Specialists fields : ");
        for (FieldSpecialist fieldSpecialist : all) {
            System.out.println("| ID field specialist : " + fieldSpecialist.getId() +
                    " | field name : " + fieldSpecialist.getSubService().getName() +
                    " | specialist name : " + fieldSpecialist.getSpecialist().getFirstName() +
                    " " + fieldSpecialist.getSpecialist().getLastName());
        }
        Long id = 0L;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println("Enter ID field that you want to delete : ");
                id = Inputs.getLongNum();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Input should be number !!!");
                scanner.next();
            }

            fieldSpecialistService.deleteById(id);

        }
    }

    private void listSpecialistNewJoiner() {
        List<Specialist> specialistsBySituation = specialistService
                .findSpecialistsBySituation(SpecialistSituation.NEW_JOINER);
        System.out.println("Specialists list :");
        for (Specialist specialist : specialistsBySituation) {
            System.out.println("| ID specialist : " + specialist.getId() +
                    " | Name specialist : " + specialist.getFirstName() +
                    " | Last Name specialist : " + specialist.getLastName());
        }
    }

    private void listSpecialistApproved() {
        List<Specialist> specialistsBySituation = specialistService
                .findSpecialistsBySituation(SpecialistSituation.APPROVED);
        System.out.println("Specialists list :");
        for (Specialist specialist : specialistsBySituation) {
            System.out.println("| ID specialist : " + specialist.getId() +
                    " | Name specialist : " + specialist.getFirstName() +
                    " | Last Name specialist : " + specialist.getLastName());
        }
    }
}
