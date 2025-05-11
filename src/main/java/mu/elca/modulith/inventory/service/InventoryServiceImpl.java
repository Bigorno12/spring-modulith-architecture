package mu.elca.modulith.inventory.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.inventory.exception.InventoryNotFound;
import mu.elca.modulith.inventory.model.Inventory;
import mu.elca.modulith.inventory.out.InventoryService;
import mu.elca.modulith.inventory.out.InventoryView;
import mu.elca.modulith.inventory.repository.InventoryRepository;
import mu.elca.modulith.order.events.OrderEvent;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public void saveInventory(InventoryView inventoryView) {
        var inventory = new Inventory();
        inventory.productCode(inventoryView.productCode());
        inventory.quantity(inventoryView.quantity());
        inventoryRepository.save(inventory);
    }

    @Override
    public InventoryView getInventory() {
        return null;
    }

    @ApplicationModuleListener
    public void decreaseQuantity(OrderEvent event) {
        log.info("Order Event: {}", event);
        inventoryRepository.findInventoryByProductCode(event.productCode())
                .map(inventory -> inventory.quantity(inventory.quantity() - event.quantity()))
                .map(inventoryRepository::save)
                .orElseThrow(() -> new InventoryNotFound("No Inventory found for Product Code: " + event.productCode()));
    }
}
