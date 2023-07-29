package ecommerce.controller;

import ecommerce.model.Car;
import ecommerce.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @PostMapping
    public static ResponseEntity<?> addCar(@RequestBody Car car) {
        return CarService.create(car);
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public static List<Car> carsList() {
        return CarService.listAll(); 
    }

    @GetMapping("/{id}")
    public static ResponseEntity<Car> carsById(@PathVariable long id) {
        return CarService.serviceReadById(id);
    }
// manufacturer, model, price, speed, maxspeed, transmission, engine, color,
// gearshift, seats, fuel, consume, acceleration, description

    @DeleteMapping(value = "/{id}")
    public static ResponseEntity<Void> deleteCostumer(@PathVariable long id) {
        return CarService.delete(id);
    }

    @PutMapping("/{id}")
    public static ResponseEntity<?> update(@RequestBody Car car, @PathVariable long id) {
        return CarService.update(car, id);
    }

/**

    @PutMapping("/update/{id}")
    public static void updateTestZinho(
            @RequestBody CostumerRequestDTO costumerRequestDTO,
            @PathVariable long id) {
        Costumer costumerTest = CarDAO.read(id);

        // name, email, password, whatsapp, cpf, birth
        costumerTest.setName(costumerRequestDTO.getName());
        costumerTest.setEmail(costumerRequestDTO.getEmail());
        costumerTest.setPassword(costumerRequestDTO.getPassword());
        costumerTest.setWhatsapp(costumerRequestDTO.getWhatsapp());
        CarDAO.update(costumerTest);
    }
    */

}
