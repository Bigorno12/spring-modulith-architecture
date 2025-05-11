package mu.elca.modulith.inventory.controller;

import lombok.RequiredArgsConstructor;
import mu.elca.modulith.inventory.out.InventoryView;
import mu.elca.modulith.inventory.service.InventoryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/inventory")
public class InventoryController {
    private final InventoryServiceImpl inventoryService;

    @PostMapping("/create")
    public ResponseEntity<Void> createInventory(@RequestBody InventoryView inventoryView) {
        inventoryService.saveInventory(inventoryView);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
