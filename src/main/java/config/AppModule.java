package config;

import com.google.inject.AbstractModule;
import repository.custom.SupplierDao;
import repository.custom.impl.SupplierDaoImpl;
import service.custom.SupplierService;
import service.custom.impl.SupplierServiceImpl;

public class AppModule extends AbstractModule {

    @Override
    public void configure(){
        bind(SupplierService.class).to(SupplierServiceImpl.class);
        bind(SupplierDao.class).to(SupplierDaoImpl.class);
    }
}
