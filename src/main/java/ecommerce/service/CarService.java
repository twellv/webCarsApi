package ecommerce.service;

import ecommerce.dao.CarDAO;
import ecommerce.model.Car;
import ecommerce.util.PaginatedResponse;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarService {
    public static boolean TEST_ENVIRONMENT = true;
    private CarDAO carDAO;

    public CarService(CarDAO carDAO){
        this.carDAO = carDAO;
    }

    public HashMap<Car, Boolean> create(Car carJSON) {
        Car car;
        HashMap<Car, Boolean> map = new HashMap<>();
        CarDAO carDAO = new CarDAO();

            if (carJSON != null) {
                car = new Car();
                BeanUtils.copyProperties(carJSON, car);
                map = carDAO.createCar(car);
            }
        return map;
    }

    public PaginatedResponse<Car> getItems(int page, int size) {
        int offset = page * size;
        List<Car> cars = carDAO.findPaginated(offset, size);
        int totalItems = carDAO.countItems();
        return new PaginatedResponse<>(cars, totalItems, page, size);
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
            cr1.setPlate(c.getPlate());
            carResponseList.add(cr1);
        }
        return carResponseList;
    }

    public boolean update(Car car, long id) {
        Car carFromDatabase = new CarDAO().readCarById(id);

        if(carFromDatabase == null) {
            return false;
        }

        BeanUtils.copyProperties(car,carFromDatabase);

        return carDAO.update(carFromDatabase);
    }

    public Car readById(long id){
        CarDAO carDAO = new CarDAO();
        return carDAO.readCarById(id);
    }

    public boolean delete(long id) {
         return new CarDAO().delete(id);
    }

}
