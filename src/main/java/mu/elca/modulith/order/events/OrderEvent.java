package mu.elca.modulith.order.events;

import lombok.Builder;

@Builder
public record OrderEvent(String orderNumber, String customerName, String customerEmail, String customerPhone) {
    public OrderEvent {
        if (orderNumber == null) {
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
    }
}
