package ecommerce;

import ecommerce.dao.CarDAO;
import ecommerce.dao.Connector;
import ecommerce.model.Car;
import ecommerce.service.CarService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarDAOTest {

    CarDAO carDAO = new CarDAO();

    @BeforeEach
    public void setUp() {
        try(Connection connection = Connector.connect_test_env();PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM car WHERE car.manufacturer ='DataAccess2' AND car.model ='daoSEDAN2';")){
            preparedStatement.executeUpdate();
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Test
    void shouldCreateCarACar() {
        CarService.TEST_ENVIRONMENT = true;

        // LIST
        List<Car> list = carDAO.listAll();
        Assertions.assertNotNull(list, "list should be not null");

        // CREATE
            Car car = new Car("DataAccess2","daoSEDAN2");
            HashMap<Car, Boolean> savedCar = carDAO.createCar(car);
            Map.Entry<Car, Boolean> entry = savedCar.entrySet().iterator().next();
            Assertions.assertEquals(entry.getKey().getManufacturer(), car.getManufacturer(), "Assert that car was saved on DB");
            Assertions.assertEquals(entry.getKey().getModel(), car.getModel(), "Assert that car was saved on DB");

        // READ-ID
            Car readCar = carDAO.readCarById(entry.getKey().getId());
            Assertions.assertNotNull(readCar, "Try to find a car was successfully");

        // UPDATE
            readCar.setManufacturer("newDataAccess2");
            readCar.setModel("newdaoSEDAN2");
            boolean isUpToDate = carDAO.update(readCar);
            Assertions.assertTrue(isUpToDate, "Assure that update process was done");
            Assertions.assertNotNull(carDAO.readCarById(readCar.getId()), "Car is available on database");

        // DELETE
            Assertions.assertTrue(carDAO.delete(readCar.getId()), "Should return true if was deleted");
            Assertions.assertNull(carDAO.readCarById(readCar.getId()), "This car wasnt found in database");

        CarService.TEST_ENVIRONMENT = false;
    }


    @Test
    @DisplayName("Should return the maximum ID from the Car table")
    void getMaxId(){
        CarService.TEST_ENVIRONMENT = true;

        Car car = new Car("DataAccess2", "daoSEDAN2");
        HashMap<Car, Boolean> savedCar = carDAO.createCar(car);
        Map.Entry<Car, Boolean> entry = savedCar.entrySet().iterator().next();
        Assertions.assertNotNull(savedCar, "savedCar should be not null");

        long maxId = carDAO.getMaxId();
        Assertions.assertTrue(maxId > 0, "The maximum ID should be greater than 0");
        Assertions.assertEquals(entry.getKey().getId(), maxId, "These 2 values has to be the same");

        CarService.TEST_ENVIRONMENT = false;
    }

}
