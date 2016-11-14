package com.hermes.web.addhaul;

import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.HaulBuilder;
import com.hermes.core.domain.hauls.HaulBuilderFactory;
import com.hermes.core.infrastructure.dataaccess.services.EmployeeService;
import com.hermes.core.infrastructure.dataaccess.services.HaulService;
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
public class AddHaulController {

    private static final String ADDHAUL_VIEW_NAME = "addhaul/addhaul";

    @Autowired
    HaulService haulService;
    @Autowired
    HaulBuilderFactory haulBuilderFactory;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "addhaul")
    public String addHaul(Model model) {
        model.addAttribute("haulBuilderLocal", haulBuilderFactory.createHaulBuilder());
        model.addAttribute("employees", employeeService.getAll());
        return ADDHAUL_VIEW_NAME;
    }

    @RequestMapping(value = "addhaul", method = RequestMethod.POST)
    public String addHaul(@Valid @ModelAttribute HaulBuilder haulBuilder, Errors errors, RedirectAttributes ra) {
        System.out.println("Here");
        if (errors.hasErrors()) {
            return ADDHAUL_VIEW_NAME;
        }
        try {
            AbstractHaul haul = haulBuilder.getHaul();
        }catch (IllegalStateException e){
            System.out.println("Haul builder not complete: "+e);
            return ADDHAUL_VIEW_NAME;
        }
        System.out.println("Success");
        return "redirect:/";
    }
}
