package com.hermes.web.add.addaccount;

import com.hermes.core.domain.accounts.AbstractAccount;
import com.hermes.core.domain.accounts.AccountFactory;
import com.hermes.core.domain.accounts.LoginAlreadyTakenException;
import com.hermes.core.domain.accounts.NoSuchRoleException;
import com.hermes.core.infrastructure.dataaccess.services.AccountService;
import com.hermes.web.trivia.signup.SignupForm;
import com.hermes.web.trivia.web.MessageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AddAccountController {

    private static final String ADDACCOUNT_VIEW_NAME = "addaccount/addaccount";

    @Autowired
    private AccountService accountService;
    @Autowired
    private AccountFactory accountFactory;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "addaccount")
    public String signup(Model model) {
        model.addAttribute(new SignupForm());
        return ADDACCOUNT_VIEW_NAME;
    }

    @RequestMapping(value = "addaccount", method = RequestMethod.POST)
    public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {

        if (errors.hasErrors()) {
            return ADDACCOUNT_VIEW_NAME;
        }

        try {
//			signupForm.setName("Pave Dudkin");
//			signupForm.setRole("admin");
            AbstractAccount newAccount = createAccount(signupForm);
            accountService.add(newAccount);
            MessageHelper.addSuccessAttribute(ra, "signup.success");
            return "redirect:/";
        }catch(LoginAlreadyTakenException | NoSuchRoleException e){
            return ADDACCOUNT_VIEW_NAME;
            //throw new IllegalStateException();
        }
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
    }

    public AbstractAccount createAccount(SignupForm signupForm)
            throws LoginAlreadyTakenException, NoSuchRoleException{

//        Role role = null;
//
//        switch (signupForm.getRole().toLowerCase()){
//            case "admin":
//                role = Role.ADMIN;
//                break;
//            case "manager":
//                role = Role.MANAGER;
//                break;
//            case "driver":
//                role = Role.DRIVER;
//                break;
//            case "informer":
//                role = Role.PLANNER;
//                break;
//            case "planner":
//                role = Role.INFORMER;
//                break;
//            default:
//                throw new NoSuchRoleException();
//        }

        return accountFactory.createAccount(
                signupForm.getLogin(),
                passwordEncoder.encode(signupForm.getPassword()),
                signupForm.getName(),
                signupForm.getRole());
    }
}
