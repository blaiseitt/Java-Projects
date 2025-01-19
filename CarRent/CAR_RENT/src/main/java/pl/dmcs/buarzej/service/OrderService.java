package pl.dmcs.buarzej.service;

import pl.dmcs.buarzej.domain.AppUserRole;
import pl.dmcs.buarzej.domain.Order;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    void editOrder(Order order);

    void removeOrder(long id);

    Order getOrder(long id);

    List<Order> listAllOrder();

    List<Order> listOrdersOfCar(long id);
}
