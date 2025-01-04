package pl.dmcs.buarzej.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carsowned")
public class CarOwned {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int version;

    @NotNull
    private String carBrand;

    @NotNull
    @Column(unique = true)
    private String carModel;

    @NotNull
    private String carCostPerDay;

    private boolean avaliable; //w momencie wypożyczenia automatycznie false, żeby było ponownie true to manager musi zatwierdzić

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarCostPerDay() {
        return carCostPerDay;
    }

    public void setCarCostPerDay(String carCostPerDay) {
        this.carCostPerDay = carCostPerDay;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

}
