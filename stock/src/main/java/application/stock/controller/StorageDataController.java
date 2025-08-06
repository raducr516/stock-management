package application.stock.controller;

import application.stock.data.StorageData;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import application.stock.servicies.StorageDataServicies;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StorageDataController {
    private final StorageDataServicies storageDataService;

    public StorageDataController(StorageDataServicies storageDataService) {
        this.storageDataService = storageDataService;
    }

    @PostMapping("/storageData")
    public ResponseEntity<?> addStorageData(@RequestBody StorageData storageData) {
        try {
            System.out.println("Received storage data: " + storageData.getName() +
                    ", " + storageData.getObjectName() +
                    ", " + storageData.getQuantity());

            storageDataService.addStorage(storageData);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            System.err.println("Controller error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }

    @GetMapping("/storageData")
    public List<StorageData> getAllStorageData() {
        return storageDataService.getAllStorageData();
    }

    @GetMapping("/storageData/history")
    public List<StorageData> getStorageHistory() {
        return storageDataService.getAllStorageDataOrdered();
    }
}