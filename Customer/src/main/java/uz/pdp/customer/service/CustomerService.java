package uz.pdp.customer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uz.pdp.clients.fraud.ApiResponse.FraudCheckResponse;
import uz.pdp.clients.fraud.FraudClient;
import uz.pdp.clients.notification.ApiResponse.NotificationRequest;
import uz.pdp.clients.notification.NotificationClient;
import uz.pdp.customer.dto.CustomerRegistrationRequest;
import uz.pdp.customer.model.Customer;
import uz.pdp.customer.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final RestTemplate restTemplate;

    private final FraudClient fraudClient;

    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // todo : check if email valid
        // todo : check if email not taken
        // todo : store customer in db

        customerRepository.save(customer);

//        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
//                "http://FRAUD/api/v1/fraud-check/{customerId}",
//                FraudCheckResponse.class,
//                customer.getId(),
//                customer.getFirstName(),
//                customer.getLastName(),
//                customer.getEmail()
//        );

        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        assert fraudCheckResponse != null;

        if (fraudCheckResponse.isFraudster()){
            throw new IllegalStateException("fraudster");
        }

        notificationClient.sendNotification(
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to IT_Masters", customer.getFirstName())
                )
        );

    }
}

