package org.example.conncetion;

import org.example.model.Admin;
import org.example.model.Client;
import org.example.model.Specialist;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactorySingleton {

    private SessionFactorySingleton() {}

    private static class LazyHolder {
        static SessionFactory INSTANCE;

        static {
            var registry = new StandardServiceRegistryBuilder()
                    .configure()
                    .build();

            INSTANCE = new MetadataSources(registry)
                    .addAnnotatedClass(Admin.class)
                    .addAnnotatedClass(Client.class)
                    .addAnnotatedClass(Specialist.class)
                    .buildMetadata()
                    .buildSessionFactory();
        }
    }

    public static SessionFactory getInstance() {
        return LazyHolder.INSTANCE;
    }
}