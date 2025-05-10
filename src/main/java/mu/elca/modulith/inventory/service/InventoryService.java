package mu.elca.modulith.inventory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.inventory.repo.InventoryRepository;
import mu.elca.modulith.order.events.OrderEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;


    @ApplicationModuleListener
    public void test(OrderEvent event) {
        log.info("Order Event: {}",event);
    }
}
