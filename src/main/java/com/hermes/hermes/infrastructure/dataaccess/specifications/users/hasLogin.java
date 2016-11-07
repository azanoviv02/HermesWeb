package com.hermes.hermes.infrastructure.dataaccess.specifications.users;


import com.hermes.hermes.domain.users.AbstractUser;
import com.hermes.hermes.infrastructure.dataaccess.specifications.AbstractSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 * Created by ivan on 02.11.16.
 */
public class hasLogin extends AbstractSpecification<AbstractUser> {

    private String login;

    hasLogin(String login) {
        this.login = login;
    }

    public boolean isSatisfiedBy(AbstractUser user) {
        return user.getLogin() == this.login;
    }

    public Criterion toCriterion() {
        return Restrictions.eq("login", this.login);
    }
}
