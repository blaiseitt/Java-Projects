package pl.dmcs.buarzej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.*;
import pl.dmcs.buarzej.domain.AppUser;
import pl.dmcs.buarzej.domain.Order;
import pl.dmcs.buarzej.service.AppUserService;
import pl.dmcs.buarzej.service.CarService;
import pl.dmcs.buarzej.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class ProductsController {

    private OrderService orderService;
    private CarService carService;
    private AppUserService appUserService;

    @Autowired
    public ProductsController(OrderService orderService, CarService carService, AppUserService appUserService) {
        this.orderService = orderService;
        this.carService = carService;
        this.appUserService = appUserService;
    }

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String listCarsToBorrow(Model model) {

        model.addAttribute("carOwnedList", carService.listCarOwned());

        return "products";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String goToOrderPhase(@RequestParam("carOwnedId") Long id, Model model, HttpServletRequest request, Principal principal) {
        model.addAttribute("carOwned", carService.getCarOwned(id));

        int orderId = ServletRequestUtils.getIntParameter(request, "orderId", -1);
        if (orderId < 0) {
            model.addAttribute("order", new Order());
        }
        if (principal == null) {
            return "orderUnsuccessful";
        }
        if (!carService.isCarAvaliable(id)) {
            return "orderUnavaliable";
        }

        //carService.setCarUnavaliable(id);
        model.addAttribute("loggedUser", appUserService.findByLogin(principal.getName()));
        return "order";
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.POST)
    public String addOrder(@ModelAttribute("order") Order order, BindingResult result, Principal principal) {

        if (principal == null && result.getErrorCount() != 0)
            return "orderUnsuccessful";

        orderService.addOrder(order);
        return "orderSuccessful";
    }

    @RequestMapping(value = "/orderViewer", method = RequestMethod.GET)
    public String viewOrders(Model model, Principal principal) {
        model.addAttribute("orderList", orderService.listAllOrder());
        model.addAttribute("loggedUser", appUserService.findByLogin(principal.getName()));
        return "orderViewer";
    }

    @RequestMapping(value = "/ordersOfUser/{userId}", method = RequestMethod.GET)
    public String viewOrdersOfUser(@PathVariable("userId") Long userId, Model model, Principal principal){
        model.addAttribute("orderList", orderService.listAllOrder());
        model.addAttribute("loggedUser", appUserService.getAppUser(userId));
        return "orderViewer";
    }

    @RequestMapping(value = "/ordersOfCar/{carId}", method = RequestMethod.GET)
    public String viewOrdersOfCar(@PathVariable("carId") Long carId, Model model, Principal principal){
        model.addAttribute("orderList", orderService.listOrdersOfCar(carId));
        model.addAttribute("loggedUser", appUserService.findByLogin(principal.getName()));
        return "orderViewer";
    }

    @RequestMapping("/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.removeOrder(orderId);
        return "redirect:/orderViewer";
    }
}
