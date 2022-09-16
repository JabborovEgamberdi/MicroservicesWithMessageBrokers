package uz.pdp.fraud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.fraud.model.CheckFraudHistory;

public interface FraudCheckHistoryRepository extends JpaRepository<CheckFraudHistory, Integer> {
}
