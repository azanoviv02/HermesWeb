package com.hermes.web.addplace;


import com.hermes.core.domain.places.AbstractPlace;
import com.hermes.core.domain.places.PlaceFactory;
import com.hermes.core.domain.places.PlaceType;
import com.hermes.core.infrastructure.dataaccess.services.PlaceService;
import com.hermes.core.infrastructure.dataaccess.specifications.places.PlaceWhich;
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
public class AddPlaceController {

    private static final String ADDPLACE_VIEW_NAME = "addplace/addplace";

    @Autowired
    PlaceService placeService;
    @Autowired
    PlaceFactory placeFactory;
    @Autowired
    PlaceWhich placeWhich;

    @RequestMapping(value = "addplace")
    public String addPlace(Model model) {
        model.addAttribute(new AddPlaceForm());
        return ADDPLACE_VIEW_NAME;
    }

    @RequestMapping(value = "addplace", method = RequestMethod.POST)
    public String addPlace(@Valid @ModelAttribute AddPlaceForm addPlaceForm, Errors errors, RedirectAttributes ra) {
        if (errors.hasErrors()) {
            return ADDPLACE_VIEW_NAME;
        }

        if(placeService.contains(placeWhich.hasName(addPlaceForm.getName()))){
            return ADDPLACE_VIEW_NAME;
        }

        AbstractPlace newPlace = createPlace(addPlaceForm);
        placeService.add(newPlace);
        MessageHelper.addSuccessAttribute(ra, "addplace.success");

        return "redirect:/";
    }
    
    AbstractPlace createPlace(AddPlaceForm addPlaceForm){
        String name = addPlaceForm.getName();
        PlaceType placeType = addPlaceForm.getPlaceType();

        switch (placeType){
            case BASIC_COMPANY_BASE:
                return placeFactory.createBasicCompanyBase(name);
            case BASIC_CLIENT_BASE:
                return placeFactory.createBasicClientBase(name);
            case BASIC_FIX:
                return placeFactory.createBasicFix(name);
            default:
                throw new IllegalStateException();
        }
    }
}
