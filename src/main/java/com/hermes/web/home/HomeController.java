package com.hermes.web.home;

import com.hermes.core.infrastructure.dataaccess.services.AccountService;
import com.hermes.core.infrastructure.dataaccess.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService employeeService;
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String index(Principal principal) {

//        List<AbstractAccount> allAccounts = accountService.getAll();
//        AbstractAccount account = null;
//
//        List<AbstractEmployee> allEmployees = employeeService.getAll();
//
//        if(true) {
//            if (allEmployees == null) {
//                throw new IllegalStateException("Haha, allEmployees empty");
//            } else {
//                throw new IllegalArgumentException("All employees: " + allEmployees.size());
//            }
//        }
//
//        if(true) {
//            if (allAccounts == null) {
//                throw new IllegalStateException("Haha, allAccounts empty");
//            } else {
//                throw new IllegalArgumentException("All accounts: " + allAccounts.size());
//            }
//        }

		return principal != null ? "home/homeSignedIn" : "home/homeNotSignedIn";
	}
}
