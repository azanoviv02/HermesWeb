package com.hermes.web.trivia.signup;

import com.hermes.core.domain.accounts.*;
import com.hermes.web.trivia.web.MessageHelper;
import com.hermes.core.infrastructure.dataaccess.services.AccountService;
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
public class SignupController {

    private static final String SIGNUP_VIEW_NAME = "signup/signup";

	@Autowired
	private AccountService accountService;
	@Autowired
	private AccountFactory accountFactory;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(value = "signup")
	public String signup(Model model) {
		model.addAttribute(new SignupForm());
        return SIGNUP_VIEW_NAME;
	}
	
	@RequestMapping(value = "signup", method = RequestMethod.POST)
	public String signup(@Valid @ModelAttribute SignupForm signupForm, Errors errors, RedirectAttributes ra) {

		if (errors.hasErrors()) {
			return SIGNUP_VIEW_NAME;
		}

		try {
//			signupForm.setName("Pave Dudkin");
//			signupForm.setRole("admin");
			AbstractAccount newAccount = createAccount(signupForm);
			accountService.add(newAccount);
			MessageHelper.addSuccessAttribute(ra, "signup.success");
			return "redirect:/";
		}catch(LoginAlreadyTakenException | NoSuchRoleException e){
			return SIGNUP_VIEW_NAME;
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
