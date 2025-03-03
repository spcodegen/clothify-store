package service.custom;

import model.Supplier;
import service.SuperService;

import java.util.List;

public interface SupplierService extends SuperService {
    boolean addSupplier(Supplier supplier);

    boolean updateSupplier(Supplier supplier);

    boolean deleteSupplier(String id);

    boolean searchSupplier(String id);

    List<Supplier> getAll();
}
