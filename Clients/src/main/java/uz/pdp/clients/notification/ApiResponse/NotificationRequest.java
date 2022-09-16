package uz.pdp.clients.notification.ApiResponse;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
