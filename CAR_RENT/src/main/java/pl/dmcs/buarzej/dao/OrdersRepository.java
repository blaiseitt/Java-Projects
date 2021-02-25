package pl.dmcs.buarzej.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.domain.Order;

import java.util.List;

@Transactional
@Repository
public interface OrdersRepository extends JpaRepository<Order, Long> {
    Order findById(long id);

    @Query("FROM Order o where o.carOwned.id=?1")
    List<Order> findOrdersWithSpecificCarId(long id);
}
