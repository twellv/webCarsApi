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

    @GetMapping("/brand/{brand}")
    public static ResponseEntity<List<Car>> carsByBrand(@PathVariable String brand) {
        return CarService.listByBrand(brand);
    }

    @GetMapping("/model/{model}")
    public static ResponseEntity<List<Car>> carsByModel(@PathVariable String model) {
        return CarService.listByModel(model);
    }

    @DeleteMapping(value = "/{id}")
    public static ResponseEntity<Void> deleteCostumer(@PathVariable long id) {
        return CarService.delete(id);
    }

    @PutMapping("/{id}")
    public static ResponseEntity<?> update(@RequestBody Car car, @PathVariable long id) {
        return CarService.update(car, id);
    }

}
