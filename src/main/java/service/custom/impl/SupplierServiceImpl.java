package service.custom.impl;


import entity.SupplierEntity;
import model.Supplier;
import org.modelmapper.ModelMapper;
import repository.DaoFactory;
import repository.custom.SupplierDao;
import service.custom.SupplierService;
import util.DaoType;

import java.util.List;

public class SupplierServiceImpl implements SupplierService {

    SupplierDao dao = DaoFactory.getInstance().getDaoType(DaoType.SUPPLIER);

    @Override
    public boolean addSupplier(Supplier supplier) {
        System.out.println("Service : "+supplier);
        SupplierEntity map = new ModelMapper().map(supplier, SupplierEntity.class);
        dao.save(map);
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
