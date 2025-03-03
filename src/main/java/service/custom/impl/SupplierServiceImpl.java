package service.custom.impl;


import model.Supplier;
import service.custom.SupplierService;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {

    @Override
    public boolean addSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean updateSupplier(Supplier supplier) {
        return false;
    }

    @Override
    public boolean deleteSupplier(String id) {
        return false;
    }

    @Override
    public boolean searchSupplier(String id) {
        return false;
    }

    @Override
    public List<Supplier> getAll() {
        return List.of();
    }
}
