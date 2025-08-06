package application.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import application.stock.data.Object;
import java.util.Optional;

@Repository
public interface ObjectRepository extends JpaRepository<Object, Long> {
    Optional<Object> findByName(String name);;
}
