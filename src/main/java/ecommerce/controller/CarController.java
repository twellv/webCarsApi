package ecommerce.controller;

import ecommerce.dao.CarDAO;
import ecommerce.model.Car;
import ecommerce.service.CarService;
import ecommerce.util.PaginatedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cars")
public class CarController {

    CarDAO carDAO = new CarDAO();
    CarService carService = new CarService(carDAO);

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        HashMap<Car, Boolean> saveCar = carService.create(car);
        Car createdCar = null;
        Boolean verified = false;

        // essa logica ta errada

        if (!saveCar.isEmpty()) {
            Map.Entry<Car, Boolean> entry = saveCar.entrySet().iterator().next();
            createdCar = entry.getKey();
            verified = entry.getValue();
        }

        return verified ?
            ResponseEntity.status(HttpStatus.OK).body(createdCar):
            ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Car>> carsList() {
        List<Car> list = carService.listAll();

        System.out.println("Lista de carros vinda do BD:");
        list.stream().forEach(c -> System.out.println(list));

        return (list == null || list.isEmpty() )?
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build():
            ResponseEntity.status(HttpStatus.OK).body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> carsById(@PathVariable long id) {
        Car read = carService.readById(id);

        return read == null?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
                ResponseEntity.status(HttpStatus.OK).body(read);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Car car, @PathVariable long id) {
        boolean verifyUpdate = carService.update(car, id);

        return !verifyUpdate?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        boolean verifyDeletion = carService.delete(id);

        return !verifyDeletion?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build():
                ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/pagination")
    public PaginatedResponse<Car> getICars(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return carService.getItems(page, size);
    }

}
