package ecommerce;

import ecommerce.dao.Connector;
import ecommerce.service.CarService;
import ecommerce.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class CarServiceTest {

    CarService carService = new CarService();

    @BeforeEach
    public void setUp() {
        try(Connection connection = Connector.connect_test_env()){
            PreparedStatement preparedStatement = connection.prepareStatement
                    ("DELETE FROM car WHERE car.manufacturer ='serviceDataAccess2' AND car.model ='serviceDAOSEDAN2';");
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    void shouldCreateACarFromService() {
        CarService.TEST_ENVIRONMENT = true;

        // LIST
        List<Car> list = carService.listAll();
        Assertions.assertNotNull(list, "list should be not null");

        // CREATE
        Car car = new Car("serviceDataAccess2","serviceDAOSEDAN2");
        HashMap<Car, Boolean> savedCar = carService.create(car);
        Map.Entry<Car, Boolean> entry = savedCar.entrySet().iterator().next();
        Assertions.assertEquals(entry.getKey().getManufacturer(), car.getManufacturer(), "Assert that car was saved on DB");
        Assertions.assertEquals(entry.getKey().getModel(), car.getModel(), "Assert that car was saved on DB");

        // READ-ID
        Car readCar = carService.readById(entry.getKey().getId());
        Assertions.assertNotNull(readCar, "Try to find a car was successfully");

        // UPDATE
        readCar.setManufacturer("serviceNewDataAccess2");
        readCar.setModel("serviceNewSEDAN2");
        boolean isUpToDate = carService.update(readCar, readCar.getId());
        Assertions.assertTrue(isUpToDate, "Assure that update process was done");
        Assertions.assertNotNull(carService.readById(readCar.getId()), "Car is available on database");

        // DELETE
        Assertions.assertTrue(carService.delete(readCar.getId()), "Should return true if was deleted");
        Assertions.assertNull(carService.readById(readCar.getId()), "This car wasnt found in database");

        CarService.TEST_ENVIRONMENT = false;
    }
}
