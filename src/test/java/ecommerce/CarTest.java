package ecommerce;

import ecommerce.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void shouldCreateCar() {
        Car car = new Car("Toyota", "Camry");

        Assertions.assertEquals("Toyota", car.getManufacturer(), "Manufacturer should be Toyota");
        Assertions.assertEquals("Camry", car.getModel(), "Model should be Camry");
        Assertions.assertNull(car.getId(), "ID should be null initially");

        car.setManufacturer("Honda");
        car.setModel("Civic");
        Assertions.assertEquals("Honda", car.getManufacturer(), "Manufacturer should now be Honda");
        Assertions.assertEquals("Civic", car.getModel(), "Model should now be Civic");
    }
}
