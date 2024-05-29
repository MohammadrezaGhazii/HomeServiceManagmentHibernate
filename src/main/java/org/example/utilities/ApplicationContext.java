package org.example.utilities;


import org.example.conncetion.SessionFactorySingleton;
import org.example.repository.admin.AdminRepository;
import org.example.repository.admin.AdminRepositoryImpl;
import org.example.repository.client.ClientRepository;
import org.example.repository.client.ClientRepositoryImpl;
import org.example.repository.creditClient.CreditClientRepository;
import org.example.repository.creditClient.CreditClientRepositoryImp;
import org.example.repository.creditSpecialist.CreditSpecialistRepository;
import org.example.repository.creditSpecialist.CreditSpecialistRepositoryImpl;
import org.example.repository.fieldSpecialist.FieldSpecialistRepository;
import org.example.repository.fieldSpecialist.FieldSpecialistRepositoryImpl;
import org.example.repository.offer.OfferRepository;
import org.example.repository.offer.OfferRepositoryImpl;
import org.example.repository.order.OrderRepository;
import org.example.repository.order.OrderRepositoryImpl;
import org.example.repository.rate.RateRepository;
import org.example.repository.rate.RateRepositoryImpl;
import org.example.repository.service.ServiceRepository;
import org.example.repository.service.ServiceRepositoryImpl;
import org.example.repository.specialist.SpecialistRepository;
import org.example.repository.specialist.SpecialistRepositoryImpl;
import org.example.repository.subService.SubServiceRepository;
import org.example.repository.subService.SubServiceRepositoryImpl;
import org.example.service.admin.AdminService;
import org.example.service.admin.AdminServiceImpl;
import org.example.service.client.ClientService;
import org.example.service.client.ClientServiceImpl;
import org.example.service.creditClient.CreditClientService;
import org.example.service.creditClient.CreditClientServiceImpl;
import org.example.service.creditSpecialist.CreditSpecialistService;
import org.example.service.creditSpecialist.CreditSpecialistServiceImpl;
import org.example.service.fieldSpecialist.FieldSpecialistService;
import org.example.service.fieldSpecialist.FieldSpecialistServiceImpl;
import org.example.service.offer.OfferService;
import org.example.service.offer.OfferServiceImpl;
import org.example.service.order.OrderService;
import org.example.service.order.OrderServiceImpl;
import org.example.service.rate.RateService;
import org.example.service.rate.RateServiceImpl;
import org.example.service.service.ServiceService;
import org.example.service.service.ServiceServiceImpl;
import org.example.service.specialist.SpecialistService;
import org.example.service.specialist.SpecialistServiceImpl;
import org.example.service.subService.SubServiceService;
import org.example.service.subService.SubServiceServiceImpl;
import org.hibernate.SessionFactory;

public class ApplicationContext {
    private final static SessionFactory SESSION_FACTORY;

    private final static AdminRepository ADMIN_REPOSITORY;
    private final static ClientRepository CLIENT_REPOSITORY;
    private final static CreditClientRepository CREDIT_CLIENT_REPOSITORY;
    private final static CreditSpecialistRepository CREDIT_SPECIALIST_REPOSITORY;
    private final static FieldSpecialistRepository FIELD_SPECIALIST_REPOSITORY;
    private final static OfferRepository OFFER_REPOSITORY;
    private final static OrderRepository ORDER_REPOSITORY;
    private final static RateRepository RATE_REPOSITORY;
    private final static ServiceRepository SERVICE_REPOSITORY;
    private final static SpecialistRepository SPECIALIST_REPOSITORY;
    private final static SubServiceRepository SUB_SERVICE_REPOSITORY;

    private final static AdminService ADMIN_SERVICE;
    private final static ClientService CLIENT_SERVICE;
    private final static CreditClientService CREDIT_CLIENT_SERVICE;
    private final static CreditSpecialistService CREDIT_SPECIALIST_SERVICE;
    private final static FieldSpecialistService FIELD_SPECIALIST_SERVICE;
    private final static OfferService OFFER_SERVICE;
    private final static OrderService ORDER_SERVICE;
    private final static RateService RATE_SERVICE;
    private final static ServiceService SERVICE_SERVICE;
    private final static SpecialistService SPECIALIST_SERVICE;
    private final static SubServiceService SUB_SERVICE_SERVICE;

    static {
        SESSION_FACTORY = SessionFactorySingleton.getInstance();

        ADMIN_REPOSITORY = new AdminRepositoryImpl(SESSION_FACTORY);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY, SESSION_FACTORY);

        CLIENT_REPOSITORY = new ClientRepositoryImpl(SESSION_FACTORY);
        CLIENT_SERVICE = new ClientServiceImpl(CLIENT_REPOSITORY, SESSION_FACTORY);

        CREDIT_CLIENT_REPOSITORY = new CreditClientRepositoryImp(SESSION_FACTORY);
        CREDIT_CLIENT_SERVICE = new CreditClientServiceImpl(CREDIT_CLIENT_REPOSITORY, SESSION_FACTORY);

        CREDIT_SPECIALIST_REPOSITORY = new CreditSpecialistRepositoryImpl(SESSION_FACTORY);
        CREDIT_SPECIALIST_SERVICE = new CreditSpecialistServiceImpl(CREDIT_SPECIALIST_REPOSITORY, SESSION_FACTORY);

        FIELD_SPECIALIST_REPOSITORY= new FieldSpecialistRepositoryImpl(SESSION_FACTORY);
        FIELD_SPECIALIST_SERVICE = new FieldSpecialistServiceImpl(FIELD_SPECIALIST_REPOSITORY,SESSION_FACTORY);

        OFFER_REPOSITORY = new OfferRepositoryImpl(SESSION_FACTORY);
        OFFER_SERVICE = new OfferServiceImpl(OFFER_REPOSITORY,SESSION_FACTORY);

        ORDER_REPOSITORY = new OrderRepositoryImpl(SESSION_FACTORY);
        ORDER_SERVICE = new OrderServiceImpl(ORDER_REPOSITORY,SESSION_FACTORY);

        RATE_REPOSITORY=new RateRepositoryImpl(SESSION_FACTORY);
        RATE_SERVICE= new RateServiceImpl(RATE_REPOSITORY,SESSION_FACTORY);

        SERVICE_REPOSITORY = new ServiceRepositoryImpl(SESSION_FACTORY);
        SERVICE_SERVICE=new ServiceServiceImpl(SERVICE_REPOSITORY,SESSION_FACTORY);

        SPECIALIST_REPOSITORY = new SpecialistRepositoryImpl(SESSION_FACTORY);
        SPECIALIST_SERVICE = new SpecialistServiceImpl(SPECIALIST_REPOSITORY,SESSION_FACTORY);

        SUB_SERVICE_REPOSITORY = new SubServiceRepositoryImpl(SESSION_FACTORY);
        SUB_SERVICE_SERVICE = new SubServiceServiceImpl(SUB_SERVICE_REPOSITORY , SESSION_FACTORY);
    }

    public static AdminService getAdminService(){return ADMIN_SERVICE;}
    public static ClientService getClientService(){return CLIENT_SERVICE;}
    public static CreditClientService getCreditClientService(){return CREDIT_CLIENT_SERVICE;}
    public static CreditSpecialistService getCreditSpecialistService(){return CREDIT_SPECIALIST_SERVICE;}
    public static FieldSpecialistService getFieldSpecialistService(){return FIELD_SPECIALIST_SERVICE;}
    public static OfferService getOfferService(){return OFFER_SERVICE;}
    public static OrderService getOrderService(){return ORDER_SERVICE;}
    public static RateService getRateService(){return RATE_SERVICE;}
    public static ServiceService getServiceService(){return SERVICE_SERVICE;}
    public static SpecialistService getSpecialistService(){return SPECIALIST_SERVICE;}
    public static SubServiceService getSubServiceService(){return SUB_SERVICE_SERVICE;}
}
