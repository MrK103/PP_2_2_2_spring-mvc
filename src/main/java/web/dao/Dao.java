package web.dao;

import web.model.Car;

import java.util.List;

public interface Dao {
    List<Car> getCars(int count);

}
