package mu.elca.modulith.product.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mu.elca.modulith.inventory.out.InventoryService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl {
    private InventoryService inventoryRepository;
}
