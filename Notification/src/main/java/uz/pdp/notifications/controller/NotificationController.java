package uz.pdp.notifications.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.notifications.ApiResponse.NotificationRequest;
import uz.pdp.notifications.service.NotificationService;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
public record NotificationController(NotificationService notificationService) {

    @PostMapping
    public void sendNotification(@RequestBody NotificationRequest notificationRequest) {
        log.info("New notification ... {}", notificationRequest);
        notificationService.send(notificationRequest);
    }
}
