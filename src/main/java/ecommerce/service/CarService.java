package ecommerce.service;

import ecommerce.dao.CarDAO;
import ecommerce.model.Car;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class CarService {

    public static ResponseEntity<Void> create(Car carRequest) {
        Car car = null;

        if(carRequest != null) {
            car = new Car();
            car.setManufacturer(carRequest.getManufacturer());
            car.setModel(carRequest.getModel());
            car.setPrice(carRequest.getPrice());
            car.setSpeed(carRequest.getSpeed());
            car.setMaxspeed(carRequest.getMaxspeed());
            car.setTransmission(carRequest.getTransmission());
            car.setEngine(carRequest.getEngine());
            car.setColor(carRequest.getColor());
            car.setGearshift(carRequest.getGearshift());
            car.setSeats(carRequest.getSeats());
            car.setFuel(carRequest.getFuel());
            car.setConsume(carRequest.getConsume());
            car.setUrlimage(carRequest.getUrlimage());
            CarDAO.create(car);
        }
        System.out.println("service: "+car);

        if (car != null) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public static List<Car> listAll() {

        List<Car> carResponseList = new ArrayList<Car>();

        for(Car c : CarDAO.readAll()) {
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
            cr1.setUrlimage(c.getUrlimage());
            carResponseList.add(cr1);
        }
        return carResponseList;
    }

    public static ResponseEntity<Car> serviceReadById(Long id){
        Car car = CarDAO.readCarById(id);

        if (car != null) {
            return ResponseEntity.status(HttpStatus.OK).body(car);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    public static ResponseEntity<?> update(Car car, long id) {
        Car oldCar = CarDAO.readCarById(id);
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
            oldCar.setUrlimage(car.getUrlimage());
            isUpdated = CarDAO.update(oldCar);
        }
        if (isUpdated) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    public static ResponseEntity<Void> delete(long id) {

        boolean isDeleted = CarDAO.delete(id);

        if (isDeleted) {
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
