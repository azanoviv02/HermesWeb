package com.hermes.web.add.addorder;

import com.hermes.core.domain.orders.AbstractOrder;
import com.hermes.core.domain.orders.OrderFactory;
import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.infrastructure.dataaccess.services.OrderService;
import com.hermes.core.infrastructure.dataaccess.services.PlaceService;
import com.hermes.web.trivia.web.MessageHelper;
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
public class AddOrderController {

    private static final String ADDORDER_VIEW_NAME = "addorder/addorder";
    private static final String NOPLACES_VIEW_NAME = "addorder/noplaces";

    @Autowired
    OrderService orderService;
    @Autowired
    OrderFactory orderFactory;

    @Autowired
    PlaceService placeService;

    @RequestMapping(value = "addorderdumb")
    public String addOrder(Model model) {
        List<AbstractPlace> places = placeService.getAll();
        if(places.size() < 2){
            return NOPLACES_VIEW_NAME;
        }
        model.addAttribute("addOrderForm", new AddOrderForm());
        model.addAttribute("places", places);
        return ADDORDER_VIEW_NAME;
    }

    @Transactional
    @RequestMapping(value = "addorderdumb", method = RequestMethod.POST)
    public String addOrder(@Valid @ModelAttribute AddOrderForm addOrderForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return ADDORDER_VIEW_NAME;
        }

        System.out.println("Inside post");

        AbstractOrder newOrder = createOrder(addOrderForm);
        orderService.add(newOrder);
        MessageHelper.addSuccessAttribute(ra, "addorder.success");

        return "redirect:/";
    }

    AbstractOrder createOrder(AddOrderForm addOrderForm) {
        List<AbstractPlace> allPlaces = placeService.getAll();

        AbstractPlace startPlace = null;
        AbstractPlace finishPlace = null;

        for(AbstractPlace place : allPlaces){
            if(place.getId().equals(addOrderForm.getStartPlaceId())){
                startPlace = place;
            }
            if(place.getId().equals(addOrderForm.getFinishPlaceId())){
                finishPlace = place;
            }
        }

        if(startPlace == null || finishPlace == null){
            throw new IllegalStateException("Places not set!");
        }

        return orderFactory.createBasicOrder(
                addOrderForm.getClientName(),
                addOrderForm.getStartDate(),
                addOrderForm.getFinishDate(),
                startPlace,
                finishPlace,
                addOrderForm.getCargoType(),
                addOrderForm.getWeight(),
                addOrderForm.getVolume(),
                addOrderForm.getAmount());
    }
}

