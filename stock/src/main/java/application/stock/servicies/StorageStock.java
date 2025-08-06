package application.stock.servicies;

import application.stock.data.Object;
import application.stock.repo.ObjectRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StorageStock {
    private final ObjectRepository objectRepo;

    public StorageStock(ObjectRepository objectRepo) {
        this.objectRepo = objectRepo;
    }

    public void addObject(Object object) {
        objectRepo.save(object);
    }
    public void addStock(String name, int quantity) {
        Object object = objectRepo.findByName(name)
                .orElseThrow(() -> new RuntimeException("Object not found"));
        object.setStock(object.getStock() + quantity);
        objectRepo.save(object);
    }
    public List<Object> getAllObjects() {
        return objectRepo.findAll();
    }
}
