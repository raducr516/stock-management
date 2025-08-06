package application.stock.servicies;

import application.stock.repo.ObjectRepository;
import application.stock.repo.StorageRepository;
import application.stock.data.StorageData;
import application.stock.data.Object;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDateTime;

@Service
public class StorageDataServicies {
    private final StorageRepository storageRepo;
    private final ObjectRepository objectRepo;

    public StorageDataServicies(StorageRepository storageRepo, ObjectRepository objectRepo) {
        this.storageRepo = storageRepo;
        this.objectRepo = objectRepo;
    }

    public void addStorage(StorageData storage) {
        try {

            if (storage.getName() == null || storage.getName().trim().isEmpty()) {
                throw new RuntimeException("Numele persoanei/departamentului este obligatoriu");
            }

            if (storage.getObjectName() == null || storage.getObjectName().trim().isEmpty()) {
                throw new RuntimeException("Numele obiectului este obligatoriu");
            }

            if (storage.getQuantity() <= 0) {
                throw new RuntimeException("Cantitatea trebuie să fie mai mare ca 0");
            }


            Object object = objectRepo.findByName(storage.getObjectName())
                    .orElseThrow(() -> new RuntimeException("Obiectul nu a fost găsit: " + storage.getObjectName()));

            if (object.getStock() < storage.getQuantity()) {
                throw new RuntimeException("Stoc insuficient pentru obiectul: " + storage.getObjectName() +
                        ". Stoc disponibil: " + object.getStock());
            }

            storage.setCreatedAt(LocalDateTime.now());

            object.setStock(object.getStock() - storage.getQuantity());
            objectRepo.save(object);

            storageRepo.save(storage);

            System.out.println("Storage operation successful: " + storage.getName() +
                    " took " + storage.getQuantity() + " of " + storage.getObjectName());

        } catch (Exception e) {
            System.err.println("Error in addStorage: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }

    public List<StorageData> getAllStorageData() {
        return storageRepo.findAll();
    }

    public List<StorageData> getAllStorageDataOrdered() {
        return storageRepo.findAllByOrderByCreatedAtDesc();
    }
}