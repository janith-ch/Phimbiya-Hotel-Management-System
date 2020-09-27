package lk.hotelManagement.backend.controller;
import lk.hotelManagement.backend.model.Supplier;
import lk.hotelManagement.backend.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @GetMapping("/")
    public List<Supplier> suppliers() {
        return supplierService.suppliers();
    }
    @PostMapping("/")
    public boolean createSupplier(@RequestBody Supplier supplier) {
        return supplierService.createSupplier(supplier);
    }
}
