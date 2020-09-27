package lk.hotelManagement.backend.service;
import lk.hotelManagement.backend.model.Supplier;
import lk.hotelManagement.backend.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> suppliers() {
        return supplierRepository.suppliers();
    }
    public boolean createSupplier(Supplier supplier) {
        return supplierRepository.createSupplier(supplier);
    }

}
