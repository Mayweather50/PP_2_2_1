package hiber.service;

import hiber.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getCars();

    Car getCarByUser(String firstName, String lastName,String email);
}
