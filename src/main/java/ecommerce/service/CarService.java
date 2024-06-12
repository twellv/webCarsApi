package ecommerce.service;

import ecommerce.dao.CarDAO;
import ecommerce.model.Car;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarService {
    public static boolean TEST_ENVIRONMENT = false;

    public HashMap<Car, Boolean> create(Car carJSON) {
        Car car;
        HashMap<Car, Boolean> map = new HashMap<>();
        CarDAO carDAO = new CarDAO();

            if (carJSON != null) {
                car = new Car();
                car.setManufacturer(carJSON.getManufacturer());
                car.setModel(carJSON.getModel());
                car.setPrice(carJSON.getPrice());
                car.setSpeed(carJSON.getSpeed());
                car.setMaxspeed(carJSON.getMaxspeed());
                car.setTransmission(carJSON.getTransmission());
                car.setEngine(carJSON.getEngine());
                car.setColor(carJSON.getColor());
                car.setGearshift(carJSON.getGearshift());
                car.setSeats(carJSON.getSeats());
                car.setFuel(carJSON.getFuel());
                car.setConsume(carJSON.getConsume());
                car.setAcceleration(carJSON.getAcceleration());
                car.setDescription(carJSON.getDescription());
                map = carDAO.createCar(car);
            }

        return map;
    }

    public List<Car> listAll() {
        CarDAO carDAO = new CarDAO();
        List<Car> carResponseList = new ArrayList<>();

        for(Car c : carDAO.listAll()) {
            Car cr1 = new Car();
            cr1.setId(c.getId());
            cr1.setManufacturer(c.getManufacturer());
            cr1.setModel(c.getModel());
            cr1.setPrice(c.getPrice());
            cr1.setSpeed(c.getSpeed());
            cr1.setMaxspeed(c.getMaxspeed());
            cr1.setTransmission(c.getTransmission());
            cr1.setEngine(c.getEngine());
            cr1.setColor(c.getColor());
            cr1.setGearshift(c.getGearshift());
            cr1.setSeats(c.getSeats());
            cr1.setFuel(c.getFuel());
            cr1.setConsume(c.getConsume());
            cr1.setAcceleration(c.getAcceleration());
            cr1.setDescription(c.getDescription());
            carResponseList.add(cr1);
        }
        return carResponseList;
    }

    public boolean update(Car car, long id) {
        CarDAO carDAO = new CarDAO();
        Car oldCar = new CarDAO().readCarById(id);
        boolean isUpdated = false;

        if(oldCar != null) {
            oldCar.setManufacturer(car.getManufacturer());
            oldCar.setModel(car.getModel());
            oldCar.setPrice(car.getPrice());
            oldCar.setSpeed(car.getSpeed());
            oldCar.setMaxspeed(car.getMaxspeed());
            oldCar.setTransmission(car.getTransmission());
            oldCar.setEngine(car.getEngine());
            oldCar.setColor(car.getColor());
            oldCar.setGearshift(car.getGearshift());
            oldCar.setSeats(car.getSeats());
            oldCar.setFuel(car.getFuel());
            oldCar.setConsume(car.getConsume());
            oldCar.setAcceleration(car.getAcceleration());
            oldCar.setDescription(car.getDescription());
            isUpdated = carDAO.update(oldCar);
        }
        return isUpdated;
    }

    public Car readById(long id){
        CarDAO carDAO = new CarDAO();
        return carDAO.readCarById(id);
    }

    public boolean delete(long id) {
         return new CarDAO().delete(id);
    }

}
