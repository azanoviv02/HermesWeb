package com.hermes.web.add.addplace;


import com.hermes.web.add.addorderflow.AddOrderFormFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
