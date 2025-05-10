package mu.elca.modulith.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.order.dto.OrderDto;
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

    public void createOrder(OrderDto orderDto) {
        var order = new Order();
        order.orderNumber(orderDto.orderNumber());
        order.customerName(orderDto.customerName());
        order.customerEmail(orderDto.customerEmail());
        order.customerPhone(orderDto.customerPhone());
        order.productCode(orderDto.productCode());
        order.productPrice(orderDto.productPrice());
        order.quantity(orderDto.quantity());
        order.comments(orderDto.comments());
        order.deliveryAddress(orderDto.deliveryAddress());
        order.productName(orderDto.productName());
        order.status(orderDto.status());
        orderRepository.save(order);
    }

    public OrderDto getOrder(Long id) {
        OrderDto orderDto = orderRepository.findById(id).map(order -> OrderDto.builder()
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
                .orderNumber(orderDto.orderNumber())
                .customerName(orderDto.customerName())
                .customerEmail(orderDto.customerEmail())
                .customerPhone(orderDto.customerPhone())
                .build()
        );
        return orderDto;
    }
}
