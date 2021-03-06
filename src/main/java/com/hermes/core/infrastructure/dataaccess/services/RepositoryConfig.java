package com.hermes.core.infrastructure.dataaccess.services;

import com.hermes.core.domain.accounts.AbstractAccount;
import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.milestones.AbstractMilestone;
import com.hermes.core.domain.orders.AbstractOrder;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by ivan on 08.11.16.
 */
@Configuration
public class RepositoryConfig {

    @Autowired
    SessionFactory sessionFactory;

    @Bean(name = "cargoRepository")
    public GenericRepository<AbstractCargo> cargoRepository(){
        return new GenericRepositoryImpl<>(AbstractCargo.class, sessionFactory);
    }

    @Bean(name = "employeeRepository")
    public GenericRepository<AbstractEmployee> employeeRepository(){
//        if(sessionFactory == null){
//            throw new IllegalStateException("No session factory!");
//        }
//        System.out.println("Employee repository configured!");
        return new GenericRepositoryImpl<>(AbstractEmployee.class, sessionFactory);
    }

    @Bean(name = "haulRepository")
    public GenericRepository<AbstractHaul> haulRepository(){
        return new GenericRepositoryImpl<>(AbstractHaul.class, sessionFactory);
    }

    @Bean(name = "milestoneRepository")
    public GenericRepository<AbstractMilestone> milestoneRepository(){
        return new GenericRepositoryImpl<>(AbstractMilestone.class, sessionFactory);
    }

    @Bean(name = "orderRepository")
    public GenericRepository<AbstractOrder> orderRepository(){
        return new GenericRepositoryImpl<>(AbstractOrder.class, sessionFactory);
    }

    @Bean(name = "placeRepository")
    public GenericRepository<AbstractPlace> placeRepository(){
        return new GenericRepositoryImpl<>(AbstractPlace.class, sessionFactory);
    }

    @Bean(name = "accountRepository")
    public GenericRepository<AbstractAccount> accountRepository(){
        return new GenericRepositoryImpl<>(AbstractAccount.class, sessionFactory);
    }

    @Bean(name = "vehicleRepository")
    public GenericRepository<AbstractVehicle> vehicleRepository(){
        return new GenericRepositoryImpl<>(AbstractVehicle.class, sessionFactory);
    }


}
