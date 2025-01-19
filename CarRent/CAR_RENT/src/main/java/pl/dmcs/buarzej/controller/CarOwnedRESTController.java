package pl.dmcs.buarzej.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dmcs.buarzej.dao.CarsRepository;
import pl.dmcs.buarzej.domain.AppUser;
import pl.dmcs.buarzej.domain.CarOwned;

@RestController
@RequestMapping("carOwnedRest")
public class CarOwnedRESTController {
    private CarsRepository carsRepository;

    @Autowired
    public CarOwnedRESTController(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @RequestMapping(value = "/{carOwnedModel}", method = RequestMethod.GET, produces = "application/json")
    public CarOwned getCarOwnedInJSON(@PathVariable String carOwnedModel) {

        return carsRepository.findByCarModel(carOwnedModel);
    }

    @RequestMapping(value = "/{carOwnedModel}.xml", method = RequestMethod.GET, produces = "application/xml")
    public CarOwned getAppUserInXML(@PathVariable String carOwnedModel) {

        return carsRepository.findByCarModel(carOwnedModel);
    }

}
