package pl.dmcs.buarzej.service;

import pl.dmcs.buarzej.domain.CarOwned;

import java.util.List;

public interface CarService {

    void addCarOwned(CarOwned carOwned);

    void editCarOwned(CarOwned carOwned);

    void removeCarOwned(long id);

    List<CarOwned> listCarOwned();

    CarOwned getCarOwned(long id);

    boolean isCarAvaliable(long id);

    void setCarUnavaliable(long id);
}
