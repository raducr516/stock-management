package application.stock.controller;


import org.springframework.web.bind.annotation.*;
import application.stock.servicies.StorageStock;
import application.stock.data.Object;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class StorageStockController {
    private final StorageStock storageStockService;

    public StorageStockController(StorageStock storageStockService) {
        this.storageStockService = storageStockService;
    }

    @PostMapping("/addObject")
    public void addObjectToStock(@RequestBody Object object) {
        storageStockService.addObject(object);
    }
    @PutMapping("/addStock/{name}/{quantity}")
    public void addStock(@PathVariable String name, @PathVariable int quantity) {
        storageStockService.addStock(name, quantity);
    }
    @GetMapping("/objects")
    public List<Object> getAllObjects() {
        return storageStockService.getAllObjects();
    }
}
