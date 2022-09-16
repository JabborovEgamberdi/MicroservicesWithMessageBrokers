package uz.pdp.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import uz.pdp.clients.notification.ApiResponse.NotificationRequest;


@FeignClient(value = "notification", path = "api/v1/notification")
public interface NotificationClient {

    @PostMapping
    void sendNotification(NotificationRequest notificationRequest);

}
