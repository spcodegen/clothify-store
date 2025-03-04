package repository.custom;

import entity.SupplierEntity;
import model.Supplier;
import repository.CrudRepository;
import repository.SuperDao;

public interface SupplierDao extends CrudRepository<SupplierEntity,String> {
}
