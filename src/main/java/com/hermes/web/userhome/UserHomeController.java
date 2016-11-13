package com.hermes.web.addplace;


import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.places.PlaceFactory;
import com.hermes.core.domain.places.PlaceType;
import com.hermes.core.infrastructure.dataaccess.services.PlaceService;
import com.hermes.core.infrastructure.dataaccess.specifications.places.PlaceWhich;
import com.hermes.web.addorder.AddOrderFormFactory;
import com.hermes.web.web.MessageHelper;
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
public class UserHomeController {

    @Autowired
    private AddOrderFormFactory addOrderFormFactory;

    private static final String INFORMERHOME_VIEW_NAME = "userhome/managerhome";

    @RequestMapping(value = "managerhome")
    public String addPlace(Model model) {
        model.addAttribute("addOrderFormFactory", addOrderFormFactory);
        return INFORMERHOME_VIEW_NAME;
    }
//
//    @RequestMapping(value = "/addordercontroller", method = RequestMethod.GET)
//    public void search(SearchCriteria searchCriteria, Principal currentUser, Model model) {
//        if (currentUser != null) {
//            List<Booking> booking = bookingService.findBookings(currentUser.getName());
//            model.addAttribute(booking);
//        }
//    }
}
