package com.hermes.hermes.domain.users;

import com.hermes.hermes.domain.employees.AbstractEmployee;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;

/**
 * Created by ivan on 31.10.16.
 */
@Entity
@DiscriminatorValue("REPRESENTED_USER")
public class RepresentedUser extends BasicUser {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "ID")
    @Cascade({CascadeType.ALL})
    private AbstractEmployee representation;

    RepresentedUser() {
    }

    RepresentedUser(String login, String password, String name, Role role, AbstractEmployee representation) {
        super(login, password, name, role);
        this.representation = representation;
    }

    public AbstractEmployee getRepresentation() {
        return representation;
    }

    public void setRepresentation(AbstractEmployee representation) {
        this.representation = representation;
    }
}
