package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.transaction.annotation.Transactional;

public class CarServiceImp implements CarService {
    private final CarDao carDao;


    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
