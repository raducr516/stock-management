package application.stock.repo;

import application.stock.data.StorageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<StorageData, String> {
    Optional<StorageData> findByName(String name);
    List<StorageData> findAllByOrderByCreatedAtDesc();
}
