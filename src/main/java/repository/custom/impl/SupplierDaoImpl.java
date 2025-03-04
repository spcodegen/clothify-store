package repository.custom.impl;

import config.HibernateConfig;
import entity.SupplierEntity;
import model.Supplier;
import org.hibernate.Session;
import repository.custom.SupplierDao;

import java.util.List;

public class SupplierDaoImpl implements SupplierDao {

    @Override
    public boolean save(SupplierEntity entity) {
        System.out.println("Repository :"+entity);

        Session session = HibernateConfig.getSession();
        session.beginTransaction();
        session.persist(entity);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public boolean update(String s, SupplierEntity entity) {
        return false;
    }

    @Override
    public boolean delete(String s) {
        return false;
    }

    @Override
    public SupplierEntity search(String s) {
        return null;
    }

    @Override
    public List<SupplierEntity> getAll() {
        return List.of();
    }
}
