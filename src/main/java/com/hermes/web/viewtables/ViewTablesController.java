package com.hermes.web.viewtables;


import com.hermes.core.infrastructure.dataaccess.services.AccountService;
import com.hermes.core.infrastructure.dataaccess.services.CargoService;
import com.hermes.core.infrastructure.dataaccess.services.OrderService;
import com.hermes.core.infrastructure.dataaccess.services.PlaceService;
import com.hermes.core.infrastructure.dataaccess.specifications.accounts.AccountWhich;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewTablesController {

    private static final String PLACES_VIEW_NAME = "tables/places";
    private static final String ACCOUNTS_VIEW_NAME = "tables/accounts";
    private static final String ORDERS_VIEW_NAME = "tables/orders";
    private static final String CARGO_VIEW_NAME = "tables/cargo";

    @Autowired
    PlaceService placeService;
    @Autowired
    AccountService accountService;
    @Autowired
    AccountWhich accountWhich;
    @Autowired
    OrderService orderService;
    @Autowired
    CargoService cargoService;

    @RequestMapping(value = "places")
    public String PLACESs(Model model) {
        model.addAttribute("places", placeService.getAll());
        return PLACES_VIEW_NAME;
    }

    @RequestMapping(value = "accounts")
    public String viewUsers(Model model) {
        model.addAttribute("admins", accountService.getEvery(accountWhich.isAdmin()));
        model.addAttribute("drivers", accountService.getEvery(accountWhich.isDriver()));
        model.addAttribute("managers", accountService.getEvery(accountWhich.isManager()));
        model.addAttribute("planners", accountService.getEvery(accountWhich.isPlanner()));
        model.addAttribute("informers", accountService.getEvery(accountWhich.isInformer()));
        return ACCOUNTS_VIEW_NAME;
    }

    @RequestMapping(value = "orders")
    public String viewOrders(Model model) {
        model.addAttribute("orders", orderService.getAll());
        return ORDERS_VIEW_NAME;
    }

    @RequestMapping(value = "cargo")
    public String viewCargo(Model model) {
        model.addAttribute("cargo", cargoService.getAll());
        return CARGO_VIEW_NAME;
    }
}
