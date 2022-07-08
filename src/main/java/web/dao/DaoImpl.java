package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;
import web.util.InitCars;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class DaoImpl implements Dao {
    private static final List<Car> carList = InitCars.getCarList();

    @Override
    public List<Car> getCars(int count) {
        if (count == 0 || count > 5) {
            return carList;
        }

        return carList.stream().limit(count).collect(Collectors.toList());
    }
}