package uz.pdp.notifications;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import uz.pdp.amqp.RabbitMQMessageProducer;
import uz.pdp.notifications.config.NotificationConfig;

@SpringBootApplication(
        scanBasePackages = {
                "uz.pdp.notifications",
                "uz.pdp.amqp",
        }
)
@EnableEurekaClient
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
                RabbitMQMessageProducer producer,
                NotificationConfig notificationConfig
    ){
        return args -> {
            producer.publish(
                    "foo",
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey()
            );
        };
    }
}
