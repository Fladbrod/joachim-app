package kea.mandatory1.joachimapp.controllers;

import io.swagger.annotations.Api;
import kea.mandatory1.joachimapp.models.Car;
import kea.mandatory1.joachimapp.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "Car controller", description = "REST endpoints for cars")
@RestController
public class Cars {

    @Autowired
    CarRepository carRepo;

    @GetMapping("/cars")
    public Iterable<Car> getCar() {
        return carRepo.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable Long id) {
        return carRepo.findById(id).get();
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car newCar) {
        return carRepo.save(newCar);
    }

    @PutMapping("/cars/{id}")
    public Car updateCarById(@PathVariable Long id, @RequestBody Car newCar) {
        newCar.setId(id);
        return carRepo.save(newCar);
    }

    @PatchMapping("/cars/{id}")
    public String patchCarById(@PathVariable Long id, @RequestBody Car carToUpdateWith) {
        return carRepo.findById(id).map(foundCar -> {
            if (carToUpdateWith.getBrand() != null) foundCar.setBrand(carToUpdateWith.getBrand());
            if (carToUpdateWith.getType() != null) foundCar.setType(carToUpdateWith.getType());
            if (carToUpdateWith.getEngine() != null) foundCar.setEngine(carToUpdateWith.getEngine());
            if (carToUpdateWith.getYear() != 0) foundCar.setYear(carToUpdateWith.getYear());

            carRepo.save(foundCar);
            return "Car Updated";
        }).orElse("Car not found");
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        carRepo.deleteById(id);
    }
}
