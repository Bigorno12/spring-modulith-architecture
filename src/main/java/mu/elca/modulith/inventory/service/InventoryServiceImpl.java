package mu.elca.modulith.inventory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.inventory.InventoryDto;
import mu.elca.modulith.inventory.InventoryService;
import mu.elca.modulith.inventory.repository.InventoryRepository;
import mu.elca.modulith.order.events.OrderEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    public InventoryDto getInventory() {
        return null;
    }

    @ApplicationModuleListener
    public void test(OrderEvent event) {
        log.info("Order Event: {}", event);
    }
}
