package com.hermes.core.infrastructure.dataaccess.specifications.users;


import com.hermes.core.domain.users.AbstractUser;
import com.hermes.core.domain.users.Role;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class hasRole extends AbstractSpecification<AbstractUser> {

    private Role role;

    hasRole(Role role) {
        this.role = role;
    }

    public boolean isSatisfiedBy(AbstractUser user) {
        return user.getRole() == this.role;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("role", this.role);
    }
}
