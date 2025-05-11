package mu.elca.modulith.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.order.dto.OrderView;
import mu.elca.modulith.order.events.OrderEvent;
import mu.elca.modulith.order.exception.ProductNotFoundException;
import mu.elca.modulith.order.model.Order;
import mu.elca.modulith.order.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    public void createOrder(OrderView orderView) {
        var order = new Order();
        order.orderNumber(orderView.orderNumber());
        order.customerName(orderView.customerName());
        order.customerEmail(orderView.customerEmail());
        order.customerPhone(orderView.customerPhone());
        order.productCode(orderView.productCode());
        order.productPrice(orderView.productPrice());
        order.quantity(orderView.quantity());
        order.comments(orderView.comments());
        order.deliveryAddress(orderView.deliveryAddress());
        order.productName(orderView.productName());
        order.status(orderView.status());
        orderRepository.save(order);
    }

    public OrderView getOrder(Long id) {
        OrderView orderView = orderRepository.findById(id).map(order -> OrderView.builder()
                        .orderNumber(order.orderNumber())
                        .customerName(order.customerName())
                        .customerEmail(order.customerEmail())
                        .customerPhone(order.customerPhone())
                        .productCode(order.productCode())
                        .productPrice(order.productPrice())
                        .quantity(order.quantity())
                        .comments(order.comments())
                        .deliveryAddress(order.deliveryAddress())
                        .productName(order.productName())
                        .status(order.status())
                        .build())
                .orElseThrow(() -> new ProductNotFoundException("Id does not exist"));
        eventPublisher.publishEvent(OrderEvent.builder()
                .orderNumber(orderView.orderNumber())
                .customerName(orderView.customerName())
                .customerEmail(orderView.customerEmail())
                .customerPhone(orderView.customerPhone())
                .build()
        );
        return orderView;
    }
}
