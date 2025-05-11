package mu.elca.modulith.inventory.out;

public record InventoryView(String productCode, Long quantity) {
    public InventoryView {
        if (productCode == null) {
            throw new IllegalArgumentException("Product code cannot be null");
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }
}
