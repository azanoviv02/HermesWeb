package com.hermes.web.add.addhaul;

import com.hermes.core.domain.employees.AbstractEmployee;
import com.hermes.core.domain.hauls.AbstractHaul;
import com.hermes.core.domain.hauls.BasicHaul;
import com.hermes.core.domain.hauls.HaulBuilderFactory;
import com.hermes.core.domain.orders.AbstractOrder;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.vehicles.AbstractVehicle;
import com.hermes.core.infrastructure.dataaccess.services.*;
import com.hermes.core.infrastructure.dataaccess.specifications.employees.EmployeeWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
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
    private static final String NOSOMETHING_VIEW_NAME = "addhaul/nosomething";

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
    OrderService orderService;

    @RequestMapping(value = "addhaul")
    public String addHaul(Model model) {

        List<AbstractOrder> orders = orderService.getAll();
        if(orders.isEmpty()){
            model.addAttribute("entity", "orders");
            model.addAttribute("message", "Get some orders");
            return NOSOMETHING_VIEW_NAME;
        }

        List<AbstractPlace> places = placeService.getAll();
        if(places.isEmpty()){
            model.addAttribute("entity", "places");
            model.addAttribute("message", "Add some places");
            return NOSOMETHING_VIEW_NAME;
        }

        List<AbstractVehicle> vehicles = vehicleService.getAll();
        if(vehicles.isEmpty()){
            model.addAttribute("entity", "vehicles");
            model.addAttribute("message", "Add some trucks");
            return NOSOMETHING_VIEW_NAME;
        }

        List<AbstractEmployee> employees = employeeService.getEvery(employeeWhich.isDriver());
        if(employees.isEmpty()){
            model.addAttribute("entity", "drivers");
            model.addAttribute("message", "Hire some drivers");
            return NOSOMETHING_VIEW_NAME;
        }

        model.addAttribute("addHaulForm", new AddHaulForm());;
        model.addAttribute("places", places);
        model.addAttribute("employees", employees);
        model.addAttribute("vehicles", vehicles);
        model.addAttribute("orders", orders);
        return ADDHAUL_VIEW_NAME;
    }


    @Transactional
    @RequestMapping(value = "addhaul", method = RequestMethod.POST)
    public String addHaul(@Valid @ModelAttribute AddHaulForm addHaulForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return ADDHAUL_VIEW_NAME;
        }

        try {
            AbstractHaul newHaul = createHaul(addHaulForm);
            haulService.add(newHaul);
        }catch(Exception e){
            e.printStackTrace();
        }

        return "redirect:/";
    }

    AbstractHaul createHaul(AddHaulForm addHaulForm){

        AbstractHaul newHaul = new BasicHaul();

        List<AbstractEmployee> allEmployees = employeeService.getAll();
        for(AbstractEmployee employee : allEmployees){
            if(employee.getId().equals(addHaulForm.getAssignedDriverId())){
                newHaul.setAssignedDriver(employee);
                break;
            }
        }

        List<AbstractVehicle> allVehicles = vehicleService.getAll();
        for(AbstractVehicle vehicle : allVehicles){
            if(vehicle.getId().equals(addHaulForm.getAssignedVehicleId())){
                newHaul.setAssignedVehicle(vehicle);
                break;
            }
        }

        List<AbstractPlace> allPlaces = placeService.getAll();
        for(AbstractPlace place : allPlaces){
            if(place.getId().equals(addHaulForm.getStartPlaceId())){
                newHaul.setStartPlace(place);
            }
            if(place.getId().equals(addHaulForm.getFinishPlaceId())){
                newHaul.setFinishPlace(place);
            }
        }

        newHaul.setStartDate(addHaulForm.getStartDate());
        newHaul.setFinishDate(addHaulForm.getFinishDate());

        return newHaul;
    }

//    void addCargo(AbstractHaul newHaul, List<UUID> cargoIdList){
//        for(AbstractCargo cargo : cargoService.getAll()){
//            if(cargoIdList.contains(cargo.getId())){
//                System.out.println("Cargo found");
//                cargo.setHaul(newHaul);
//                System.out.println("Updating");
////                cargoService.update(cargo);
//            }
//        }
//    }
}
