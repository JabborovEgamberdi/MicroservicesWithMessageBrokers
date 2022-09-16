package uz.pdp.notifications.ApiResponse;

public record NotificationRequest(
        Integer toCustomerId,
        String toCustomerName,
        String message
) {
}
