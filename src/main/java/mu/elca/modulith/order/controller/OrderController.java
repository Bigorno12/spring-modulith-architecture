package mu.elca.modulith.order.controller;

import lombok.RequiredArgsConstructor;
import mu.elca.modulith.order.dto.OrderView;
import mu.elca.modulith.order.service.OrderServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/order")
public class OrderController {

    private final OrderServiceImpl orderServiceImpl;

    @PostMapping("create")
    public ResponseEntity<Void> createOrder(@RequestBody OrderView orderView) {
        orderServiceImpl.createOrder(orderView);
        return ResponseEntity.ok().build();
    }

    @GetMapping("order-retrieve/{id}")
    public ResponseEntity<OrderView> getOrderById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(orderServiceImpl.getOrder(id));
    }
}
