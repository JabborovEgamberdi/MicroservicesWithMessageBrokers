package uz.pdp.notifications.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.notifications.ApiResponse.NotificationRequest;
import uz.pdp.notifications.model.Notifications;
import uz.pdp.notifications.repository.NotificationRepository;

import java.time.LocalDateTime;


@Service
@AllArgsConstructor
public class NotificationService {

    public final NotificationRepository notificationRepository;

    public void send(NotificationRequest notificationRequest) {
        notificationRepository.save(
                Notifications.builder()
                        .toCustomerId(notificationRequest.toCustomerId())
                        .toCustomerEmail(notificationRequest.toCustomerName())
                        .sender("Egamberdi")
                        .message(notificationRequest.message())
                        .sentAt(LocalDateTime.now())
                        .build()
        );
    }
}