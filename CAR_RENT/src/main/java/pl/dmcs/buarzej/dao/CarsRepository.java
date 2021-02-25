package pl.dmcs.buarzej.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.buarzej.domain.CarOwned;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface CarsRepository extends JpaRepository<CarOwned, Long> {

    CarOwned findById(long id);

    CarOwned findByCarModel(String carModel);

}
