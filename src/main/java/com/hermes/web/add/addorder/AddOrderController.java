package com.hermes.web.add.addorder;

import com.hermes.core.domain.orders.AbstractOrder;
import com.hermes.core.domain.orders.OrderFactory;
import com.hermes.core.infrastructure.dataaccess.services.OrderService;
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
public class AddOrderController {

    private static final String ADDORDER_VIEW_NAME = "addorder/addorder";

    @Autowired
    OrderService orderService;
    @Autowired
    OrderFactory orderFactory;

    @RequestMapping(value = "addorderdumb")
    public String addOrder(Model model) {
        model.addAttribute(new AddOrderForm());
        return ADDORDER_VIEW_NAME;
    }

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
        return orderFactory.createBasicOrder(
                addOrderForm.getClientName(),
                addOrderForm.getStartDate(),
                addOrderForm.getFinishDate(),
                addOrderForm.getCargoType(),
                addOrderForm.getWeight(),
                addOrderForm.getVolume(),
                addOrderForm.getAmount());
    }
}

