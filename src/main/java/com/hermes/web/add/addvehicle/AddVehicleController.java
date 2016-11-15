package com.hermes.web.add.addvehicle;


import com.hermes.core.domain.vehicles.AbstractVehicle;
import com.hermes.core.domain.vehicles.VehicleFactory;
import com.hermes.core.domain.vehicles.VehicleType;
import com.hermes.core.infrastructure.dataaccess.services.VehicleService;
import com.hermes.web.trivia.web.MessageHelper;
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
public class AddVehicleController {

    private static final String ADDVEHICLE_VIEW_NAME = "addvehicle/addvehicle";

    @Autowired
    VehicleService vehicleService;
    @Autowired
    VehicleFactory vehicleFactory;

    @RequestMapping(value = "addvehicle")
    public String addVehicle(Model model) {
        model.addAttribute(new AddVehicleForm());
        return ADDVEHICLE_VIEW_NAME;
    }

    @RequestMapping(value = "addvehicle", method = RequestMethod.POST)
    public String addVehicle(@Valid @ModelAttribute AddVehicleForm addVehicleForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return ADDVEHICLE_VIEW_NAME;
        }

        AbstractVehicle newVehicle = createVehicle(addVehicleForm);
        vehicleService.add(newVehicle);
        MessageHelper.addSuccessAttribute(ra, "addvehicle.success");

        return "redirect:/";
    }
    
    AbstractVehicle createVehicle(AddVehicleForm addVehicleForm){
        VehicleType vehicleType = addVehicleForm.getVehicleType();
        switch (vehicleType){
            case BASIC_TRUCK:
                return vehicleFactory.createBasicTruck();
            default:
                throw new IllegalStateException();
        }
    }
}
