package com.hermes.web.backdoor;

import com.hermes.core.domain.cargo.CargoType;
import com.hermes.core.domain.orders.OrderBuilder;
import com.hermes.core.domain.orders.OrderBuilderFactory;
import com.hermes.core.infrastructure.dataaccess.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

/**
 * Created by ivan on 13.11.16.
 */
@Controller
public class BackdoorController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderBuilderFactory orderBuilderFactory;

    @RequestMapping(value = "/backdoor", method = RequestMethod.GET)
    public String addorder(Principal principal) {
        OrderBuilder orderBuilder = orderBuilderFactory.createOrderBuilder();
        orderBuilder.setClientName("Pasha");
        orderBuilder.addCargo(CargoType.BOX, 10.0, 10.0, 50);
        orderBuilder.addCargo(CargoType.BOX, 100.0, 100.0, 10);
        orderBuilder.addCargo(CargoType.BOX, 5, 8, 6);
        orderService.add(orderBuilder.getOrder());
        System.out.println("Added things!");
        return "backdoor/backdoor";
    }
}
