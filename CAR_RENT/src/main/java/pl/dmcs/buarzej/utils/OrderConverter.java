package pl.dmcs.buarzej.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.buarzej.domain.Order;
import pl.dmcs.buarzej.service.OrderService;

public class OrderConverter implements Converter<String, Order> {

    private OrderService orderService;

    @Autowired
    public OrderConverter(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public Order convert(String s) {
        return orderService.getOrder(Integer.parseInt(s));
    }
}
