package com.hermes.core.infrastructure.dataaccess.specifications.accounts;


import com.hermes.core.domain.accounts.AbstractAccount;
import com.hermes.core.domain.accounts.Role;
import com.hermes.core.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class HasRole extends AbstractSpecification<AbstractAccount> {

    private Role role;

    HasRole(Role role) {
        this.role = role;
    }

    public boolean isSatisfiedBy(AbstractAccount account) {
        return account.getRole() == this.role;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("role", this.role);
    }
}
