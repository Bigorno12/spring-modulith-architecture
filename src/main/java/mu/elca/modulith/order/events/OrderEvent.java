package mu.elca.modulith.order.events;

import lombok.Builder;
import org.springframework.modulith.events.Externalized;

@Builder
@Externalized("StoreExchange::order.new")
public record OrderEvent(String productCode, String customerName, String customerEmail, String customerPhone, Integer quantity) {
    public OrderEvent {
        if (productCode == null) {
            throw new IllegalArgumentException("orderNumber cannot be null");
        }

        if (customerName == null) {
            throw new IllegalArgumentException("customerName cannot be null");
        }

        if (customerEmail == null) {
            throw new IllegalArgumentException("customerEmail cannot be null");
        }

        if (customerPhone == null) {
            throw new IllegalArgumentException("customerPhone cannot be null");
        }

        if (quantity == null) {
            throw new IllegalArgumentException("quantity cannot be null");
        }
    }
}
