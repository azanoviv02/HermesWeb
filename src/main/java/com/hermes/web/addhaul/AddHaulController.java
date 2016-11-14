package com.hermes.web.addhaul;

import com.hermes.core.domain.cargo.AbstractCargo;
import com.hermes.core.domain.employees.AbstractDriver;
import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.HaulBuilder;
import com.hermes.core.domain.hauls.HaulBuilderFactory;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import com.hermes.core.infrastructure.dataaccess.services.*;
import com.hermes.core.infrastructure.dataaccess.specifications.employees.EmployeeWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AddHaulController {

    private static final String ADDHAUL_VIEW_NAME = "addhaul/addhaul";

    @Autowired
    HaulService haulService;
    @Autowired
    HaulBuilderFactory haulBuilderFactory;

    @Autowired
    PlaceService placeService;

    @Autowired
    EmployeeService employeeService;
    @Autowired
    EmployeeWhich employeeWhich;

    @Autowired
    VehicleService vehicleService;

    @Autowired
    CargoService cargoService;

    @RequestMapping(value = "addhaul")
    public String addHaul(Model model) {
        model.addAttribute("addHaulForm", new AddHaulForm());
        model.addAttribute("places", placeService.getAll());
        model.addAttribute("employees", employeeService.getEvery(employeeWhich.isDriver()));
        model.addAttribute("vehicles", vehicleService.getAll());
        model.addAttribute("cargo", cargoService.getAll());
        return ADDHAUL_VIEW_NAME;
    }

    @RequestMapping(value = "addhaul", method = RequestMethod.POST)
    public String addHaul(@Valid @ModelAttribute AddHaulForm addHaulForm, Errors errors, RedirectAttributes ra) {

        HaulBuilder haulBuilder = haulBuilderFactory.createHaulBuilder();

        List<AbstractEmployee> allEmployees = employeeService.getEvery(employeeWhich.isDriver());
        for(AbstractEmployee employee : allEmployees){
            if(employee.getId().equals(addHaulForm.getAssignedDriverId())){
                haulBuilder.setAssignedDriver((AbstractDriver) employee);
                break;
            }
        }

        List<AbstractVehicle> allVehicles = vehicleService.getAll();
        for(AbstractVehicle vehicle : allVehicles){
            if(vehicle.getId().equals(addHaulForm.getAssignedVehicleId())){
                haulBuilder.setAssignedVehicle((AbstractVehicle) vehicle);
                break;
            }
        }

        if(addHaulForm.getFinishDate() == null){
            System.out.println("Nullo finish date");
        }

        if(addHaulForm.getStartDate() == null){
            System.out.println("Nullo start date");
        }

        List<AbstractPlace> allPlaces = placeService.getAll();
        for(AbstractPlace place : allPlaces){
            if(place.getId().equals(addHaulForm.getStartPlaceId())){
                haulBuilder.setStart(addHaulForm.getStartDate(), place);
            }
            if(place.getId().equals(addHaulForm.getFinishPlaceId())){
                haulBuilder.setFinish(addHaulForm.getFinishDate(), place);
            }
        }

        List<AbstractCargo> allCargo = cargoService.getAll();
        for(AbstractCargo cargoItem : allCargo){
            if(addHaulForm.getCargoIdList().contains(cargoItem.getId())){
                haulBuilder.addCargo(cargoItem);
            }
        }

        System.out.println("Success!");

        AbstractHaul newHaul = haulBuilder.getHaul();

        haulService.addOrUpdate(newHaul);

//        System.out.println(newHaul.getVersion());
//
//        try {
//            haulService.addOrUpdate(newHaul);
//        }catch (Exception e){
//            System.out.println("Bad :(");
//            System.out.println(newHaul.getId());
//            System.out.println(newHaul.getVersion());
//            System.out.println(newHaul.getStart().getVersion());
//            System.out.println(newHaul.getFinish().getVersion());
//            System.out.println(e);
//            try {
//                haulService.addOrUpdate(newHaul);
//            }catch(Exception em){
//                System.out.println("Second time!");
//                System.out.println(newHaul.getId());
//                System.out.println(newHaul.getVersion());
//                System.out.println(newHaul.getStart().getVersion());
//                System.out.println(newHaul.getFinish().getVersion());
//                System.out.println(em);
//            }
//        }

        return "redirect:/";
    }
}
