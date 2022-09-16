package uz.pdp.notifications.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.notifications.model.Notifications;

@Repository
public interface NotificationRepository extends JpaRepository<Notifications, Integer> {
}
