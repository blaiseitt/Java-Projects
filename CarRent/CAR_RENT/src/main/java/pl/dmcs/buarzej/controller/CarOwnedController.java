package pl.dmcs.buarzej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.buarzej.domain.CarOwned;
import pl.dmcs.buarzej.service.CarService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CarOwnedController {

    private CarService carService;

    @Autowired
    public CarOwnedController(CarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/carsOwned")
    public String showCarsOwned(Model model, HttpServletRequest request) {

        int carOwnedId = ServletRequestUtils.getIntParameter(request, "carOwnedId", -1);

        if (carOwnedId > 0)
            model.addAttribute("carOwned", carService.getCarOwned(carOwnedId));
        else
            model.addAttribute("carOwned", new CarOwned());

        model.addAttribute("carOwnedList", carService.listCarOwned());

        return "carOwned";
    }

    @RequestMapping(value = "/addCarOwned", method = RequestMethod.POST)
    public String addCar(@ModelAttribute("carOwned") CarOwned carOwned, BindingResult result, HttpServletRequest request) {

        if (carOwned.getId() == 0)
            carService.addCarOwned(carOwned);
        else
            carService.editCarOwned(carOwned);

        return "redirect:carsOwned.html";
    }

    @RequestMapping("/deleteCarOwned/{carOwnedId}")
    public String deleteCar(@PathVariable("carOwnedId") Integer carOwnedId) {

        carService.removeCarOwned(carOwnedId);
        return "redirect:/carsOwned.html";
    }
}