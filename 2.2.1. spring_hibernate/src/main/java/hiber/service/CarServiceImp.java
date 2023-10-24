package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService {

    @Autowired
    CarDao carDao;
    @Transactional
    @Override
    public void addCar(Car car) {
        carDao.addCar(car);

    }
    @Transactional
    @Override
    public List<Car> getCars() {
        return carDao.getCars();
    }
    @Transactional
    @Override
    public Car getCarByUser(String firstName, String lastName, String email) {
        return carDao.getCarByUser(firstName,lastName,email);
    }
}
