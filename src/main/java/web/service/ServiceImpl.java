package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.Dao;
import web.dao.DaoImpl;
import web.model.Car;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl implements Service{
    @Autowired
    private Dao dao = new DaoImpl();

    @Override
    public List<Car> getCars(int count) {
        return dao.getCars(count);
    }
}
