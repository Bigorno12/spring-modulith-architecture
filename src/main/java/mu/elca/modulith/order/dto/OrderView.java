package mu.elca.modulith.order.dto;

import lombok.Builder;

@Builder
public record OrderView(String orderNumber, String customerName, String customerEmail, String customerPhone,
                        String deliveryAddress, String productCode, String productName, String productPrice,
                        Integer quantity, String status, String comments) {

    public OrderView {
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

        if (deliveryAddress == null) {
            throw new IllegalArgumentException("deliveryAddress cannot be null");
        }

        if (productCode == null) {
            throw new IllegalArgumentException("productCode cannot be null");
        }

        if (productName == null) {
            throw new IllegalArgumentException("productName cannot be null");
        }

        if (productPrice == null) {
            throw new IllegalArgumentException("productPrice cannot be null");
        }

        if (quantity == null) {
            throw new IllegalArgumentException("quantity cannot be null");
        }

        if (status == null) {
            throw new IllegalArgumentException("status cannot be null");
        }
    }
}
