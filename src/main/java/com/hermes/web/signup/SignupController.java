package com.hermes.web.signup;

import com.hermes.web.web.MessageHelper;
import com.hermes.core.domain.users.AbstractUser;
import com.hermes.core.domain.users.LoginAlreadyTakenException;
import com.hermes.core.domain.users.NoSuchRoleException;
import com.hermes.core.domain.users.UserFactory;
import com.hermes.core.infrastructure.dataaccess.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private UserService userService;
	@Autowired
	private UserFactory userFactory;
	
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
			AbstractUser newUser = userFactory.createUser(signupForm);
			userService.add(newUser);
			MessageHelper.addSuccessAttribute(ra, "signup.success");
			return "redirect:/";
		}catch(LoginAlreadyTakenException | NoSuchRoleException e){
			return SIGNUP_VIEW_NAME;
			//throw new IllegalStateException();
		}
        // see /WEB-INF/i18n/messages.properties and /WEB-INF/views/homeSignedIn.html
	}
}
