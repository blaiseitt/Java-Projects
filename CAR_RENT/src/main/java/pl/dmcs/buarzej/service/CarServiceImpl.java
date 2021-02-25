package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.dao.CarsRepository;
import pl.dmcs.buarzej.domain.CarOwned;

import java.util.List;

@Service("carService")
@Transactional
public class CarServiceImpl implements CarService {

    private CarsRepository carsRepository;

    @Autowired
    public CarServiceImpl(CarsRepository carsRepository) {
        this.carsRepository = carsRepository;
    }

    @Transactional
    public void addCarOwned(CarOwned carOwned) {
        carsRepository.save(carOwned);
    }

    @Transactional
    public void editCarOwned(CarOwned carOwned) {
        carsRepository.save(carOwned);
    }

    @Transactional
    public void removeCarOwned(long id) {
        carsRepository.delete(id);
    }

    @Transactional
    public CarOwned getCarOwned(long id) {
        return carsRepository.findById(id);
    }

    @Transactional
    public List<CarOwned> listCarOwned() {
        return carsRepository.findAll();
    }

    @Transactional
    public boolean isCarAvaliable(long id) {
        return carsRepository.findById(id).isAvaliable();
    }

    @Transactional
    public void setCarUnavaliable(long id) {
        carsRepository.findById(id).setAvaliable(false);
    }
}
