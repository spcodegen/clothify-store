package repository;

import repository.custom.impl.SupplierDaoImpl;
import service.custom.impl.SupplierServiceImpl;
import util.DaoType;

public class DaoFactory {
    private static DaoFactory instance;

    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return instance == null ? instance = new DaoFactory() : instance;
    }

    public <T extends SuperDao> T getDaoType(DaoType type) {
        switch (type) {
            case SUPPLIER:
                return (T) new SupplierDaoImpl();
        }
        return null;
    }

}
