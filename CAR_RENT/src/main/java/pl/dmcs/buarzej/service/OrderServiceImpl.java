package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.dao.OrdersRepository;
import pl.dmcs.buarzej.domain.Order;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    private OrdersRepository ordersRepository;

    @Autowired
    public OrderServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Transactional
    public void addOrder(Order order) {
        ordersRepository.save(order);
    }

    @Transactional
    public void editOrder(Order order) {
        ordersRepository.save(order);
    }

    @Transactional
    public void removeOrder(long id) {
        ordersRepository.delete(id);
    }

    @Transactional
    public Order getOrder(long id) {
        return ordersRepository.findById(id);
    }

    @Transactional
    public List<Order> listAllOrder() {
        return ordersRepository.findAll();
    }

    @Override
    public List<Order> listOrdersOfCar(long id) {

        return ordersRepository.findOrdersWithSpecificCarId(id);
    }

}
