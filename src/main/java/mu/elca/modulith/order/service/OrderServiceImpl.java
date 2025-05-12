package mu.elca.modulith.order.service;

import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.order.dto.OrderView;
import mu.elca.modulith.order.events.OrderEvent;
import mu.elca.modulith.order.exception.ProductNotFoundException;
import mu.elca.modulith.order.model.Order;
import mu.elca.modulith.order.repository.OrderRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
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
        OrderEvent build = new OrderEvent(orderView.productCode(),
                orderView.customerName(),
                orderView.customerEmail(),
                orderView.customerPhone(),
                orderView.quantity());
        eventPublisher.publishEvent(build);
    }

    public OrderView getOrder(Long id) {
        return orderRepository.findById(id).map(order -> OrderView.builder()
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
    }
}
