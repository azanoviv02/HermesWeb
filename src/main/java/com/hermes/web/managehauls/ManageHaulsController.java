package com.hermes.web.managehauls;


import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.infrastructure.dataaccess.services.HaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ManageHaulsController {

    private static final String HAULS_VIEW_NAME = "managehauls/managehauls";
    private static final String NOHAULS_VIEW_NAME = "managehauls/nohauls";

    @Autowired
    HaulService haulService;

    @RequestMapping(value = "managehauls")
    public String viewHauls(Model model) {
        List<AbstractHaul> hauls = haulService.getAll();
        if(hauls.isEmpty()){
            return NOHAULS_VIEW_NAME;
        }
        model.addAttribute("hauls", haulService.getAll());
        return HAULS_VIEW_NAME;
    }
}
